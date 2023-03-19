import {  NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { BalanceEnquiryComponent } from './balance-enquiry/balance-enquiry.component';
import { ContactComponent } from './contact/contact.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { DashboardPageComponent } from './dashboard-page/dashboard-page.component';
import { DeleteAccountComponent } from './delete-account/delete-account.component';
import { DeleteCustomerComponent } from './delete-customer/delete-customer.component';
import { DepositComponent } from './deposit/deposit.component';
import { EditAccountComponent } from './edit-account/edit-account.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { HomePageComponent } from './home-page/home-page.component';
import { MiniStatementComponent } from './mini-statement/mini-statement.component';
import { NewCustomerComponent } from './new-customer/new-customer.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { WithdrawComponent } from './withdraw/withdraw.component';

const routes: Routes = [
  {path:'',component:HomePageComponent},
  {path:'login',component:UserLoginComponent},
  {path:'dashboardpageroute/:role/fundTransfer',component:FundTransferComponent},
  {path:'dashboardpageroute/:role/editAccount',component:EditAccountComponent},
  {path:'dashboardpageroute/:role/editCustomer',component:EditCustomerComponent},
  {path:'dashboardpageroute/:role/newCustomer',component:NewCustomerComponent},
  {path:'dashboardpageroute/:role/createAccount',component:CreateAccountComponent},
  {path:'dashboardpageroute/:role/miniStatement',component:MiniStatementComponent},
  {path:'dashboardpageroute/:role/editAccount',component:EditAccountComponent},
  {path:'dashboardpageroute/:role/editCustomer',component:EditCustomerComponent},
  {path:'dashboardpageroute/:role/deleteAccount',component:DeleteAccountComponent},
  {path:'dashboardpageroute/:role/deleteCustomer',component:DeleteCustomerComponent},
  {path:'dashboardpageroute/:role/withdraw',component:WithdrawComponent},
  {path:'dashboardpageroute/:role/balanceEnquiry',component:BalanceEnquiryComponent},
  {path:'dashboardpageroute/:role/deposit',component:DepositComponent},
  {path:'dashboardpageroute/:role',component:DashboardPageComponent},
  {path:'about', component:AboutComponent},
  {path:'contact', component:ContactComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
