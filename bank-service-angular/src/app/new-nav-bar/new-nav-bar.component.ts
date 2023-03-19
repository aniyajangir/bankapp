import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-new-nav-bar',
  templateUrl: './new-nav-bar.component.html',
  styleUrls: ['./new-nav-bar.component.css']
})
export class NewNavBarComponent implements OnInit {
  isLoggedIn: boolean = false;
  
  constructor(private route:Router, private userService:UserService ) { 
  }

  ngOnInit(): void {
    
  }

  onSubmit(){
    this.route.navigate(['login']);
    this.isLoggedIn = true;
  }
  
  logout(): void {
    this.userService.logout().subscribe(data => {
      console.log(data);
      this.isLoggedIn = false;
      this.route.navigate(['']);
    })
  }
  // isLoggedIn(): boolean{
  //    return 
  // }
}
