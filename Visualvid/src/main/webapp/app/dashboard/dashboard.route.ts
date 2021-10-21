import { Route } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { DashboardOrdersComponent } from './main/orders/orders.component';
import { DashboardVideoDesignsComponent } from './main/videodesigns/videodesigns.component';
import { DashboardEmployeComponent } from './main/employees/employe-component';
import { DashboardAssignmentsComponent } from './main/assignments/assignments.component';
import { DashboardCategoriesComponent } from './main/categories/categories.component';
import { DashboardSubscriptionComponent } from './main/subscriptions/subscriptions.component';
import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';

export const DASHBOARD_ROUTE: Route = {
  path: 'dashboard',
  component: DashboardComponent,
  children: [
    { path: 'orders', component: DashboardOrdersComponent },
    { path: 'videodesigns', component: DashboardVideoDesignsComponent },
    { path: 'employees', component: DashboardEmployeComponent },
    { path: 'assignments', component: DashboardAssignmentsComponent },
    { path: 'categories', component: DashboardCategoriesComponent },
    { path: 'subscriptions', component: DashboardSubscriptionComponent },
    {
      path: 'admin',
      data: {
        authorities: [Authority.ADMIN],
      },
      canActivate: [UserRouteAccessService],
      loadChildren: () => import('../admin/admin-routing.module').then(m => m.AdminRoutingModule),
    },
  ],
  data: {
    authorities: [],
    pageTitle: 'dashboardForm',
  },
};
