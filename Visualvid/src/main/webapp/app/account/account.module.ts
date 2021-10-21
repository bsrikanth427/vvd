import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { VisualvidSharedModule } from 'app/shared/shared.module';

import { PasswordStrengthBarComponent } from './password/password-strength-bar.component';
import { RegisterComponent } from './register/register.component';
import { ActivateComponent } from './activate/activate.component';
import { PasswordComponent } from './password/password.component';
import { PasswordResetFinishComponent } from './password-reset/finish/password-reset-finish.component';
import { SettingsComponent } from './settings/settings.component';
import { accountState } from './account.route';
import { PasswordResetInitComponent } from './password-reset/init/password-reset-init.component';
import { CustomerOrdersComponent } from 'app/customer-orders/customer-orders.component';

@NgModule({
  imports: [VisualvidSharedModule, RouterModule.forChild(accountState)],
  declarations: [
    ActivateComponent,
    RegisterComponent,
    PasswordComponent,
    PasswordStrengthBarComponent,
    PasswordResetFinishComponent,
    PasswordResetInitComponent,
    SettingsComponent,
    CustomerOrdersComponent,
  ],
})
export class AccountModule {}
