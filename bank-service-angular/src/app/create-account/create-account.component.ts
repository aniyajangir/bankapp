import { Component, OnInit } from '@angular/core';
import { Account } from '../account';
import { ManagerserviceService } from '../managerservice.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  account:Account = new Account();
  constructor(private managerService:ManagerserviceService) { }

  ngOnInit(): void {
  }

  createAccount():void{
    console.log(this.account)
    this.managerService.createAccount(this.account).subscribe(data => {
      console.log("working")
      if(this.account.minBalance>this.account.balance){
        alert("minimum balance should be less than initial balance")
      }
      else if(data=="not found"){
        alert(data)
      }
      else{
        alert(data)
      }
    },error=>alert("error"))
  }

}
