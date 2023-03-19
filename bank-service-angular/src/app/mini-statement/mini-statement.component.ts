import { Component, OnInit } from '@angular/core';
import { ManagerserviceService } from '../managerservice.service';

@Component({
  selector: 'app-mini-statement',
  templateUrl: './mini-statement.component.html',
  styleUrls: ['./mini-statement.component.css']
})
export class MiniStatementComponent implements OnInit {
  accountNumber !: number ;
  transactions : any= [];
  check : boolean = true;
  
  constructor(private managerService : ManagerserviceService) { }

  ngOnInit(): void {
  }

  onClick():void{
    this.managerService.miniStatement(this.accountNumber).subscribe(data => {
      console.log("working")
    this.check = false;
    console.log(data);
      this.transactions = data ;
      
      
    },error=>alert("error"))
  }






}
