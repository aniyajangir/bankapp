import { Component, OnInit } from '@angular/core';
import { ManagerserviceService } from '../managerservice.service';
import { Transaction } from '../transaction';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {

  result : string = "";
  check : boolean = false;
  transaction:Transaction = new Transaction();

  constructor( private managerService:ManagerserviceService) { }

  ngOnInit(): void {
  }

  deposit():void{
    this.managerService.depositBalance(this.transaction).subscribe(data => {
      console.log("working")
    
      this.result = data ;
      
    },error=>alert("error"))
  }

}
