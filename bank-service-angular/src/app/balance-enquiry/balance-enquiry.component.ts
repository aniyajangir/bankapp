import { Component, OnInit } from '@angular/core';
import { ManagerserviceService } from '../managerservice.service';

@Component({
  selector: 'app-balance-enquiry',
  templateUrl: './balance-enquiry.component.html',
  styleUrls: ['./balance-enquiry.component.css']
})
export class BalanceEnquiryComponent implements OnInit {


  accountNumber !: number ;
  result : string = "";
  check : boolean = false;

  constructor(private managerService:ManagerserviceService) { 
  }

  ngOnInit(): void {
  }

  checkCurrentBalance():void{
    this.managerService.checkBalance(this.accountNumber).subscribe(data => {
      console.log("working")
      this.result = "Account balance is : "+data ;
      
    },error=>alert("error"))
  }

}
