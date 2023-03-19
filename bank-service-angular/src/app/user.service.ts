import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userSubject: BehaviorSubject<string>;
  public globaluser!:Observable<string>;
  private baseUrl ="http://localhost:8080/user/login"
  private baseUrl2 = "http://localhost:8080/user/dashboard/logout";

  constructor(private httpClient:HttpClient) {
    localStorage.clear()
    this.userSubject = new BehaviorSubject(localStorage.getItem('token')!);
    this.globaluser= this.userSubject.asObservable();
   }

   loginUser(user:User):Observable<string>{
    console.log(user);
    //return this.httpClient.post(this.baseUrl,user);
    return this.httpClient.post(`${this.baseUrl}`,user,{responseType:'text'})
    .pipe(
      map(
        resp=>{
          if(resp)
          {  
          localStorage.setItem("token",resp)
          console.log("response"+resp)
          console.log("storage "+localStorage.getItem("token"))
          // this.globaluser=resp.valueOf
          this.userSubject.next(resp)
        }
        return resp}));
   }
   logout():Observable<String>{
    return this.httpClient.get(`${this.baseUrl2}`,{responseType:'text'});
   }
}
