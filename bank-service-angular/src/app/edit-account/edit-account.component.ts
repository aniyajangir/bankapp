import { Component, OnInit } from '@angular/core';
import { Account } from '../account';
import { ManagerserviceService } from '../managerservice.service';

@Component({
  selector: 'app-edit-account',
  templateUrl: './edit-account.component.html',
  styleUrls: ['./edit-account.component.css']
})
export class EditAccountComponent implements OnInit {

  account:Account = new Account();
  constructor(private managerService:ManagerserviceService) { }


  ngOnInit(): void {
  }
  editAccount():void{
    console.log(this.account)
    this.managerService.editAccount(this.account).subscribe(data => {
      console.log("working")
      if(data=="not found"){
        alert(data)
      }
      else{
        alert(data)
      }
    },error=>alert("error"))
  }

}
