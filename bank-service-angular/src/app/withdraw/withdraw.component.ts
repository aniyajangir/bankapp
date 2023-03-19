import { Component, OnInit } from '@angular/core';
import { ManagerserviceService } from '../managerservice.service';
import { Transaction } from '../transaction';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent implements OnInit {

  result : string = "";
  check : boolean = false;
  transaction:Transaction = new Transaction();

  constructor(private managerService:ManagerserviceService) { }

  ngOnInit(): void {
  }

  withdraw():void{
    this.managerService.withdrawAmount(this.transaction).subscribe(data => {
      console.log("working")
    
      this.result = data ;
      
    },error=>alert("error"))
  }

}
