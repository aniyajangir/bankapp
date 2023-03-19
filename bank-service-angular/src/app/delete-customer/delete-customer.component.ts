import { Component, OnInit } from '@angular/core';
import { ManagerserviceService } from '../managerservice.service';

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {
  customerId !: number ;
  result : string = "";
  check : boolean = false;
  constructor(private managerService:ManagerserviceService) { }

  ngOnInit(): void {
  }

  deleteCustomer():void{
    this.managerService.deleteCustomer(this.customerId).subscribe(data => {
      console.log("working")
    
      this.result = data ;
      console.log(data)
      
    },error=>alert("error"))
  }
}
