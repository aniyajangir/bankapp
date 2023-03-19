import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { ManagerserviceService } from '../managerservice.service';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  customer:Customer = new Customer();

  constructor(private managerService:ManagerserviceService) { }
  ngOnInit(): void {
  }

  editCustomer():void{
    console.log(this.customer)
    this.managerService.editCustomer(this.customer).subscribe(data => {
      console.log("working")
      if(data=="not found"){
        alert("try again")
      }
      else{
        alert(data)
      }
    },error=>alert("error"))
  }

}
