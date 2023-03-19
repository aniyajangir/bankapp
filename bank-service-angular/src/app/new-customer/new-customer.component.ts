import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { ManagerserviceService } from '../managerservice.service';

@Component({
  selector: 'app-new-customer',
  templateUrl: './new-customer.component.html',
  styleUrls: ['./new-customer.component.css']
})
export class NewCustomerComponent implements OnInit {

  customer:Customer = new Customer();

  constructor(private managerService:ManagerserviceService) { }

  ngOnInit(): void {
  }
  createCustomer():void{
    console.log(this.customer)
    this.managerService.createCustomer(this.customer).subscribe(data => {
      console.log("working")
      if(data==="not found"){
        alert("try again")
      }
      else{
        alert(data)
      }
    },error=>alert("error"))
  }


}
