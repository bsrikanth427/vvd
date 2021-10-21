import { Injectable, EventEmitter } from '@angular/core';
import { WindowRefService } from 'app/shared/window-ref.service';

import { RazorpayOption } from './razorpay.model';
import { CartService } from 'app/cart/cart.service';
import { Router } from '@angular/router';
import { OrderService } from 'app/order/order.service';

@Injectable({
  providedIn: 'root',
})
export class RazorpayService {
  public onPaymentSuccess: EventEmitter<any> = new EventEmitter<any>();
  constructor(
    private winRef: WindowRefService,
    private orderService: OrderService,
    private cartService: CartService,
    private router: Router
  ) {}

  payWithRazor(options: RazorpayOption): void {
    console.log('payWithRazor');
    options.handler = (response: any) => {
      const razorpayResponse = {
        razorpayPaymentId: response['razorpay_payment_id'],
        razorpayOrderId: response['razorpay_order_id'],
        razorpaySignature: response['razorpay_signature'],
      };
      if (options.name === 'Video') {
        this.orderService.updateRazorPayTransaction(razorpayResponse).subscribe(resp => {
          this.onPaymentSuccess.emit(resp);
          this.cartService.removeAllFromCart().subscribe(res => {
            this.redirect();
          });
        });
      }
      if (options.name === 'Subscription') {
        this.router.navigate(['/videos']);
        this.orderService.updateRazorPayTransactionForSubscription(razorpayResponse).subscribe(resp => {
          this.onPaymentSuccess.emit(resp);
        });
      }
    };

    const rzp = new this.winRef.nativeWindow.Razorpay(options);
    rzp.open();
  }

  redirect() {
    this.router.navigate(['/videos']);
  }
}
