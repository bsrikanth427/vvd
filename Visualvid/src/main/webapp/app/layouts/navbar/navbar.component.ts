import { AfterViewInit, Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { SessionStorageService } from 'ngx-webstorage';

import { VERSION } from 'app/app.constants';
import { LANGUAGES } from 'app/core/language/language.constants';
import { AccountService } from 'app/core/auth/account.service';
import { LoginModalService } from 'app/core/login/login-modal.service';
import { LoginService } from 'app/core/login/login.service';
import { ProfileService } from 'app/layouts/profiles/profile.service';
import { AdminMediaService } from 'app/admin/admin-upload/admin-media.service';
import { CartService } from 'app/cart/cart.service';
import { FormBuilder } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AuthServerProvider } from 'app/core/auth/auth-jwt.service';
import { Account } from 'app/core/user/account.model';

@Component({
  selector: 'jhi-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['navbar.scss'],
})
export class NavbarComponent implements OnInit, AfterViewInit {
  inProduction?: boolean;
  isNavbarCollapsed = true;
  languages = LANGUAGES;
  swaggerEnabled?: boolean;
  version: string;
  account?: Account;
  userName: string = localStorage.getItem('userName')!;
  @ViewChild('username', { static: false })
  loginModal = false;
  username?: ElementRef;
  jwtToken?: string;
  @ViewChild('el') elRefs: ElementRef | undefined;
  authenticationError = false;
  loginForm = this.fb.group({
    username: [''],
    password: [''],
    rememberMe: [false],
  });
  constructor(
    private renderer: Renderer2,
    private elRef: ElementRef,
    private loginService: LoginService,
    private languageService: JhiLanguageService,
    private sessionStorage: SessionStorageService,
    private accountService: AccountService,
    private loginModalService: LoginModalService,
    private profileService: ProfileService,
    private router: Router,
    private adminMediaService: AdminMediaService,
    private cartService: CartService,
    private accService: AccountService,
    private authService: AuthServerProvider,
    public activeModal: NgbActiveModal,
    private fb: FormBuilder
  ) {
    this.version = VERSION ? (VERSION.toLowerCase().startsWith('v') ? VERSION : 'v' + VERSION) : '';
  }

  ngOnInit(): void {
    this.profileService.getProfileInfo().subscribe(profileInfo => {
      this.inProduction = profileInfo.inProduction;
      this.swaggerEnabled = profileInfo.swaggerEnabled;
    });
  }

  ngAfterViewInit(): void {
    if (this.username) {
      setTimeout(() => this.username!.nativeElement.focus(), 0);
    }
  }

  changeLanguage(languageKey: string): void {
    this.sessionStorage.store('locale', languageKey);
    this.languageService.changeLanguage(languageKey);
  }

  collapseNavbar(): void {
    this.isNavbarCollapsed = true;
  }

  isAuthenticated(): boolean {
    return this.accountService.isAuthenticated();
  }

  loginPopup(): void {
    this.loginModalService.open();
  }

  logout(): void {
    localStorage.clear();
    this.collapseNavbar();
    this.loginService.logout();
    this.router.navigate(['']);
  }

  toggleNavbar(): void {
    // this.isNavbarCollapsed = !this.isNavbarCollapsed;
  }

  getImageUrl(): string {
    return this.isAuthenticated() ? this.accountService.getImageUrl() : '';
  }

  cancel(): void {
    this.authenticationError = false;
    this.loginForm.patchValue({
      username: '',
      password: '',
    });
    this.activeModal.dismiss('cancel');
  }

  login(): void {
    this.loginService
      .login({
        username: this.loginForm.get('username')!.value,
        password: this.loginForm.get('password')!.value,
        rememberMe: this.loginForm.get('rememberMe')!.value,
      })
      .subscribe(
        () => {
          this.authenticationError = false;
          this.jwtToken = this.authService.getToken();
          this.accService.fetch().subscribe(account => {
            localStorage.setItem('email', account.email);
            localStorage.setItem('userId', account.id);
            localStorage.setItem('userName', account.login);
            localStorage.setItem('roles', account.roles.toString());
          });
          this.activeModal.close();
          this.loginModal = !this.loginModal;
          if (
            this.router.url === '/account/register' ||
            this.router.url.startsWith('/account/activate') ||
            this.router.url.startsWith('/account/reset/')
          ) {
            this.router.navigate(['']);
          }
        },
        () => (this.authenticationError = true)
      );
  }

  register(): void {
    this.activeModal.dismiss('to state register');
    this.router.navigate(['/account/register']);
  }

  requestResetPassword(): void {
    this.activeModal.dismiss('to state requestReset');
    this.router.navigate(['/account/reset', 'request']);
  }
}
