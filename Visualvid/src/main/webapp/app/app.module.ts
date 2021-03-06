import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import './vendor';
import { VisualvidSharedModule } from 'app/shared/shared.module';
import { VisualvidCoreModule } from 'app/core/core.module';
import { VisualvidAppRoutingModule } from './app-routing.module';
import { VisualvidHomeModule } from './home/home.module';
import { VisualvidEntityModule } from './entities/entity.module';
import { UserModule } from './user/user.module';
import { ItemModule } from './item/item.module';
import { DashboardModule } from 'app/dashboard/dashboard.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ActiveMenuDirective } from './layouts/navbar/active-menu.directive';
import { ErrorComponent } from './layouts/error/error.component';
import { HttpApiService } from './http-api.service';
import { MatCardModule } from '@angular/material/card';
import { PricingComponent } from './pricing/pricing.component';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { CheckoutComponent } from './checkout/checkout.component';
// import { UserUploadIncompleteComponent } from './user-upload-incomplete/user-upload-incomplete.component';
@NgModule({
  imports: [
    BrowserAnimationsModule,
    VisualvidSharedModule,
    VisualvidCoreModule,
    VisualvidHomeModule,
    DashboardModule,
    UserModule,
    ItemModule,
    MatCardModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    VisualvidEntityModule,
    VisualvidAppRoutingModule,
  ],
  exports: [],
  declarations: [
    MainComponent,
    NavbarComponent,
    ErrorComponent,
    PageRibbonComponent,
    ActiveMenuDirective,
    FooterComponent,
    PricingComponent,
    CheckoutComponent,
  ],
  providers: [HttpApiService, NgbActiveModal],
  bootstrap: [MainComponent],
})
export class VisualvidAppModule {}
