import { Component, OnInit, ViewChild } from '@angular/core';
import { Observable, of } from 'rxjs';
import { AdminMedia } from 'app/admin/admin-upload/admin-upload-form/adminmedia.model';
import { CartService } from './cart.service';
import { OverlayService } from 'app/shared/overlay/overlay.service';
import { OrderService } from 'app/order/order.service';
import { RazorpayService } from 'app/shared/payment/razorpay/razorpay-service';
import { Pricing } from 'app/shared/pricing/pricing.model';
import { OrderRequestArr } from './orderRequest.model';
import { TemplatePortalDirective } from '@angular/cdk/portal';
import { PricingService } from 'app/shared/pricing/pricing.service';
import { ItemCustomization } from './itemCustomization';
@Component({
  selector: 'jhi-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss'],
})
export class CartComponent implements OnInit {
  public cartItems: Observable<AdminMedia[]> = of([]);
  public shoppingCartItems: AdminMedia[] = [];
  isIpIndian = true;
  advCustomizationPriceChecked = false;
  premumDeliveryPriceChecked = false;
  pricing: Pricing = {};
  public priceArr: Pricing[] = [];
  public itemCustomization: ItemCustomization[] = [];
  @ViewChild('buyNowTemplate') buyNowTemplate: TemplatePortalDirective | undefined;
  constructor(
    private cartService: CartService,
    private overlayService: OverlayService,
    private orderService: OrderService,
    private razorpayService: RazorpayService,
    private pricingService: PricingService
  ) {}
  ngOnInit() {
    this.cartItems = this.cartService.getItems();
    this.cartItems.subscribe(shoppingCartItems => {
      console.log(shoppingCartItems);
      this.shoppingCartItems = shoppingCartItems;
    });
  }

  buyNow(): void {
    this.computePrice();
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

  // Remove cart items
  public removeItem(item: AdminMedia) {
    this.cartService.removeFromCart(item).subscribe(res => {
      this.cartItems.subscribe(shoppingCartItems => {
        console.log(shoppingCartItems);
        this.shoppingCartItems = shoppingCartItems;
      });
    });
  }

  // Get Total
  public getTotal(): Observable<number> {
    return this.cartService.getTotalAmount();
  }
}
