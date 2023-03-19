import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BalanceEnquiryComponent } from './balance-enquiry/balance-enquiry.component';
import { DeleteAccountComponent } from './delete-account/delete-account.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { NewCustomerComponent } from './new-customer/new-customer.component';
import { DeleteCustomerComponent } from './delete-customer/delete-customer.component';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { DashboardPageComponent } from './dashboard-page/dashboard-page.component';
import { MiniStatementComponent } from './mini-statement/mini-statement.component';
import { EditAccountComponent } from './edit-account/edit-account.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { JWtInterceptor } from './interceptor';
import { NewNavBarComponent } from './new-nav-bar/new-nav-bar.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';

@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    BalanceEnquiryComponent,
    DeleteAccountComponent,
    CreateAccountComponent,
    DepositComponent,
    WithdrawComponent,
    NewCustomerComponent,
    DeleteCustomerComponent,
    FundTransferComponent,
    DashboardPageComponent,
    MiniStatementComponent,
    EditAccountComponent,
    EditCustomerComponent,
    NewNavBarComponent,
    HomePageComponent,
    AboutComponent,
    ContactComponent
  ],
  imports: [

    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JWtInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
