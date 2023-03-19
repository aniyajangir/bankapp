import { Component, OnInit } from '@angular/core';
import { ManagerserviceService } from '../managerservice.service';

@Component({
  selector: 'app-delete-account',
  templateUrl: './delete-account.component.html',
  styleUrls: ['./delete-account.component.css']
})
export class DeleteAccountComponent implements OnInit {

  accountNumber !: number ;
  result : string = "";
  check : boolean = false;

  constructor(private managerService:ManagerserviceService) { }

  ngOnInit(): void {
  }

  deleteAccount():void{
    this.managerService.deleteAccount(this.accountNumber).subscribe(data => {
      console.log("working")
    
      this.result = data ;
      
    },error=>alert("error"))
  }


}
