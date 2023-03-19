import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';
import { GlobalComponent } from '../global';


@Component({
  selector: 'app-dashboard-page',
  templateUrl: './dashboard-page.component.html',
  styleUrls: ['./dashboard-page.component.css']
})
export class DashboardPageComponent implements OnInit {

  visible = false;

  toggleCollapse(): void {
    this.visible = !this.visible;
  }

  constructor(private aRoute: ActivatedRoute, private userService: UserService, private route: Router) {
    GlobalComponent.mainCheck = true;
  }

  role!: string;
  checkForManager: boolean = true;
  checkForCustomer: boolean = true;


  ngOnInit(): void {
    
    let role = this.aRoute.snapshot.paramMap.get('role');

    if (role == 'manager') {
      this.checkForManager = false;
      this.role= 'manager'
    }
    else if(role == 'customer'){
      this.checkForCustomer = false;
      this.role='customer'
    }

  }


  logout(): void {
    this.userService.logout().subscribe(data => {
      console.log(data);
      this.route.navigate(['']);
    })
  }

  changeCheckForBalanceEnquiry(): void {
    console.log(this.role)
    this.route.navigate(['dashboardpageroute/' + this.role + '/balanceEnquiry']);
  }

  changeCheckForDeleteAccount(): void {
    this.route.navigate(['dashboardpageroute/' + this.role + '/deleteAccount']);
  }

  changeCheckForCreateAccount(): void {
    this.route.navigate(['dashboardpageroute/' + this.role + '/createAccount']);
  }

  changeCheckForDeposit(): void {
    this.route.navigate(['dashboardpageroute/' + this.role + '/deposit']);
  }

  changeCheckForWithdraw(): void {
    this.route.navigate(['dashboardpageroute/' + this.role + '/withdraw']);
  }
  changeCheckForCreateCustomer(): void {
    this.route.navigate(['dashboardpageroute/' + this.role + '/newCustomer']);
  }
  changeCheckForDeleteCustomer(): void {
    this.route.navigate(['dashboardpageroute/' + this.role + '/deleteCustomer']);
  }
  changeCheckForFundTransfer(): void {
    this.route.navigate(['dashboardpageroute/' + this.role + '/fundTransfer']);
  }

  changeCheckForMiniStatement(): void {
    this.route.navigate(['dashboardpageroute/' + this.role + '/miniStatement']);
  }

  changeCheckForEditAccount(): void {
    this.route.navigate(['dashboardpageroute/' + this.role + '/editAccount']);
  }

  changeCheckForEditCustomer(): void {
    this.route.navigate(['dashboardpageroute/' + this.role + '/editCustomer']);
  }


}
