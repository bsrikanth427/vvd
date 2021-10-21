import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CartComponent } from 'app/cart/cart.component';
import { errorRoute } from 'app/layouts/error/error.route';
import { navbarRoute } from 'app/layouts/navbar/navbar.route';
import { ListVideosCategoryComponent } from 'app/list-videos-category/list-videos-category.component';
import { UserUploadIncompleteComponent } from 'app/user-upload-incomplete/user-upload-incomplete.component';
import { WhishListItemsComponent } from 'app/whish-list-items/whish-list-items.component';
/* jhipster-needle-add-admin-module-import - JHipster will add admin modules imports here */
const LAYOUT_ROUTES = [navbarRoute, ...errorRoute];
@NgModule({
  imports: [
    /* jhipster-needle-add-admin-module - JHipster will add admin modules here */
    RouterModule.forChild([
      {
        path: 'account',
        loadChildren: () => import('../account/account.module').then(m => m.AccountModule),
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

      ...LAYOUT_ROUTES,
    ]),
  ],
})
export class UserRoutingModule {}
