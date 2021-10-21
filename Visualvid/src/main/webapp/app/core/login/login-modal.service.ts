import { Injectable } from '@angular/core';
import { NgbModal, NgbModalOptions, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

import { LoginModalComponent } from 'app/shared/login/login.component';

@Injectable({ providedIn: 'root' })
export class LoginModalService {
  private isOpen = false;

  constructor(private modalService: NgbModal) {}

  open(): void {
    if (this.isOpen) {
      return;
    }
    this.isOpen = true;

    const modalRef: NgbModalRef = this.modalService.open(
      LoginModalComponent,

      {
        ariaLabelledBy: 'modal-basic-title',
        size: 'lg',
        centered: true,
        windowClass: 'modal-login',
      }
    );
    modalRef.result.finally(() => (this.isOpen = false));
  }
}
