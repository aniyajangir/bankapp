import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  
  user:User = new User();
  str:string='';
  constructor(private userService : UserService,private route:Router) { 
  
  }

  ngOnInit(): void {
  }

  userLogin(){
    localStorage.clear()
    this.userService.loginUser(this.user).subscribe(data => {
     
      console.log("working")
      if(data=="not found"){
        alert("try again")
      }
      else{
        var role = data;
        this.str = role.valueOf().substring(0,8);

        if(this.str=='manager-'){
          this.str='manager'
        }
      this.route.navigate(['dashboardpageroute',this.str]);
      }
    },error=>alert("error"))
  }}
