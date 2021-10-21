import { Route } from '@angular/router';
import { CustomerOrdersComponent } from './customer-orders.component';

export const customerOrdersRoute: Route = {
  path: 'orders',
  component: CustomerOrdersComponent,
  data: {
    authorities: [],
    pageTitle: 'orders.title',
  },
};
