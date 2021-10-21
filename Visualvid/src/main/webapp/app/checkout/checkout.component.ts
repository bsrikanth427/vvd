import { TemplatePortalDirective } from '@angular/cdk/portal';
import { Component, OnInit, ViewChild } from '@angular/core';
import { AdminMedia } from 'app/admin/admin-upload/admin-upload-form/adminmedia.model';
import { CartService } from 'app/cart/cart.service';
import { ItemCustomization } from 'app/cart/itemCustomization';
import { OrderRequestArr } from 'app/cart/orderRequest.model';
import { OrderService } from 'app/order/order.service';
import { OverlayService } from 'app/shared/overlay/overlay.service';
import { RazorpayService } from 'app/shared/payment/razorpay/razorpay-service';
import { Pricing } from 'app/shared/pricing/pricing.model';
import { PricingService } from 'app/shared/pricing/pricing.service';
import { Observable, of } from 'rxjs';

@Component({
  selector: 'jhi-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss'],
})
export class CheckoutComponent implements OnInit {
  public cartItems: Observable<AdminMedia[]> = of([]);
  public shoppingCartItems: AdminMedia[] = [];
  isIpIndian = true;
  advCustomizationPriceChecked = false;
  premumDeliveryPriceChecked = false;
  pricing: Pricing = {};
  public priceArr: Pricing[] = [];
  public itemCustomization: ItemCustomization[] = [];
  currencyCode?: String;
  basicAmount?: number;
  discountAmount?: number;
  advancedCustomizationAmount?: number;
  premiumDeliveryAmount?: number;
  totalAmount?: number;
  couponDiscountAmount?: number;
  couponDiscountPercentage?: number;
  gstAmount?: number;
  gstPercentage?: number;
  couponCode?: String;
  @ViewChild('buyNowTemplate') buyNowTemplate: TemplatePortalDirective | undefined;
  constructor(
    private cartService: CartService,
    private overlayService: OverlayService,
    private orderService: OrderService,
    private razorpayService: RazorpayService,
    private pricingService: PricingService
  ) {
    this.cartItems = this.cartService.getItems();
    this.cartItems.subscribe(shoppingCartItems => {
      console.log(shoppingCartItems);
      this.shoppingCartItems = shoppingCartItems;
      this.computePrice();
    });
  }

  ngOnInit(): void {}

  buyNow(): void {
    this.overlayService.openTemplateOverlay(this.buyNowTemplate!);
    const orderRequest = this.prepareOrderRequest();
    this.orderService.createPaymentOrder(orderRequest).subscribe(data => {
      console.log(data);
      this.overlayService.closeOverlay();
      const options = {
        description: 'VisualVid',
        key: data.razorPayKey,
        // eslint-disable-next-line @typescript-eslint/camelcase
        order_id: data.razorPayOrderId,
        amount: data.amount,
        name: 'Video',
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
  computePrice(): void {
    this.priceArr = [];
    console.log(this.advCustomizationPriceChecked);
    this.shoppingCartItems.forEach(item => {
      if (item && item.id) {
        const itemCustomization = {
          adminMediaId: item.id,
          optedForAdvCustomization: this.advCustomizationPriceChecked,
          optedForPremumDelivery: this.premumDeliveryPriceChecked,
          currencyCode: this.isIpIndian ? 'INR' : 'USD',
        };
        this.pricingService.computePricing(itemCustomization).subscribe((res: Pricing) => {
          if (res) {
            console.log(this.pricing);
            this.pricing = res;
            this.priceArr.push(this.pricing);

            this.basicAmount = (this.basicAmount ? this.basicAmount : 0) + (this.pricing.basicAmount! ? this.pricing.basicAmount : 0);
            this.discountAmount = (this.discountAmount ? this.discountAmount : 0) + this.pricing.discountAmount!;
            this.advancedCustomizationAmount =
              (this.advancedCustomizationAmount ? this.advancedCustomizationAmount : 0) + this.pricing.advancedCustomizationAmount!;
            this.premiumDeliveryAmount =
              (this.premiumDeliveryAmount ? this.premiumDeliveryAmount : 0) + this.pricing.premiumDeliveryAmount!;
            this.totalAmount = (this.totalAmount ? this.totalAmount : 0) + this.pricing.totalAmount!;
            this.couponDiscountAmount = (this.couponDiscountAmount ? this.couponDiscountAmount : 0) + this.pricing.couponDiscountAmount!;
            this.couponDiscountPercentage =
              (this.couponDiscountPercentage ? this.couponDiscountPercentage : 0) + this.pricing.couponDiscountPercentage!;
            this.gstAmount = (this.gstAmount ? this.gstAmount : 0) + this.pricing.gstAmount!;
            this.gstPercentage = (this.gstPercentage ? this.gstPercentage : 0) + this.pricing.gstPercentage!;
            // couponCode?: String;
          }
        });
      }
    });
  }

  prepareOrderRequest(): OrderRequestArr {
    this.shoppingCartItems.forEach(item => {
      const currencyCode = this.isIpIndian ? 'INR' : 'USD';
      const itemCust = new ItemCustomization(item.id!, this.advCustomizationPriceChecked, this.premumDeliveryPriceChecked, currencyCode);
      this.itemCustomization.push(itemCust);
    });

    const orderRequest = {
      couponCode: '',
      currencyCode: this.isIpIndian ? 'INR' : 'USD',
      itemCustomizations: this.itemCustomization,
      userId: localStorage.getItem('userId'),
    };
    return orderRequest;
  }

  // Get Total
  public getTotal(): Observable<number> {
    return this.cartService.getTotalAmount();
  }
}
