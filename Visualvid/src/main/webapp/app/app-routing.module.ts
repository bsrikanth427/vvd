import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { errorRoute } from './layouts/error/error.route';
import { navbarRoute } from './layouts/navbar/navbar.route';
import { DEBUG_INFO_ENABLED } from 'app/app.constants';
import { ListVideosCategoryComponent } from './list-videos-category/list-videos-category.component';
import { WhishListItemsComponent } from './whish-list-items/whish-list-items.component';
import { CartComponent } from './cart/cart.component';
import { UserUploadIncompleteComponent } from './user-upload-incomplete/user-upload-incomplete.component';
import { PricingComponent } from './pricing/pricing.component';
import { CheckoutComponent } from './checkout/checkout.component';
const LAYOUT_ROUTES = [navbarRoute, ...errorRoute];

@NgModule({
  imports: [
    RouterModule.forRoot(
      [
        {
          path: 'account',
          loadChildren: () => import('./account/account.module').then(m => m.AccountModule),
        },
        {
          path: 'videos',
          component: ListVideosCategoryComponent,
        },

        {
          path: 'wishList',
          component: WhishListItemsComponent,
        },
        {
          path: 'cart',
          component: CartComponent,
        },
        {
          path: 'purchases',
          component: UserUploadIncompleteComponent,
        },

        {
          path: 'pricing',
          component: PricingComponent,
        },
        {
          path: 'checkout',
          component: CheckoutComponent,
        },

        // ...LAYOUT_ROUTES,
      ],
      { enableTracing: DEBUG_INFO_ENABLED }
    ),
  ],
  exports: [RouterModule],
})
export class VisualvidAppRoutingModule {}
