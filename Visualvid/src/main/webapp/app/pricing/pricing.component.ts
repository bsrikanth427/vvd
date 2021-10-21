import { Component, OnInit } from '@angular/core';
import { SubscriptionAddModel } from 'app/dashboard/main/subscriptions/add-subscription/add-subscription.model';
import { OrderService } from 'app/order/order.service';
import { SubscriptionService } from 'app/pricing/subscriptions.service';
import { UserSubscriptionModel } from 'app/pricing/user-subscription.model';
import { OverlayService } from 'app/shared/overlay/overlay.service';
import { RazorpayService } from 'app/shared/payment/razorpay/razorpay-service';
import { PricingService } from 'app/shared/pricing/pricing.service';
@Component({
  selector: 'jhi-pricing',
  templateUrl: './pricing.component.html',
  styleUrls: ['./pricing.component.scss'],
})
export class PricingComponent implements OnInit {
  plans: SubscriptionAddModel[] | undefined;
  userSubscription: UserSubscriptionModel | undefined;
  constructor(
    private subscriptionService: SubscriptionService,
    private overlayService: OverlayService,
    private orderService: OrderService,
    private razorpayService: RazorpayService,
    private pricingService: PricingService
  ) {}

  ngOnInit(): void {
    this.subscriptionService.getSubscriptionPlans().subscribe(res => {
      this.plans = res;
    });
  }

  buyNow(plan: SubscriptionAddModel): void {
    const userId = localStorage.getItem('userId');
    const userName = localStorage.getItem('userName');
    this.userSubscription = new UserSubscriptionModel(
      userId ? userId : '',
      plan.name,
      plan.id,
      'INR',
      userName ? userName : '',
      plan.downloads,
      '',
      '',
      plan.downloads,
      'Active',
      ''
    );
    this.subscriptionService.userSubScription(this.userSubscription).subscribe(data => {
      console.log(data);
      this.overlayService.closeOverlay();
      const options = {
        description: 'VisualVid',
        key: data.razorPayKey,
        // eslint-disable-next-line @typescript-eslint/camelcase
        order_id: data.razorPayOrderId,
        amount: data.totalAmount,
        name: 'Subscription',
        prefill: {
          email: 'test@test.com',
          contact: '+918087930476',
          name: 'Bala',
        },
        currency: data.currencyCode,
      };
      try {
        this.razorpayService.payWithRazor(options);
      } catch (e) {
        console.error(e);
      }
    });
  }
}
