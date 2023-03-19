import { Component, OnInit } from '@angular/core';
import { ManagerserviceService } from '../managerservice.service';
import { Transaction } from '../transaction';

@Component({
  selector: 'app-fund-transfer',
  templateUrl: './fund-transfer.component.html',
  styleUrls: ['./fund-transfer.component.css']
})
export class FundTransferComponent implements OnInit {

  result : string = "";
  check : boolean = false;
  transaction:Transaction = new Transaction();
  constructor(private managerService:ManagerserviceService) { }

  ngOnInit(): void {
  }

  fundTransfer():void{
    this.managerService.fundTransfer(this.transaction).subscribe(data => {
      console.log("working")
    
      this.result = data ;
      
    },error=>alert("error"))
  }


}
