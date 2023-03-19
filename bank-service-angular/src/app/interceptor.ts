import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { observable, Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { UserService } from "./user.service";

@Injectable()
export class JWtInterceptor implements HttpInterceptor {
    constructor(private loginService: UserService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        // add auth header with jwt if user is logged in and request is to the api url
        // const user= this.loginService.globaluser;
        const user1=localStorage.getItem("token");
        // console.log("interceptor"+user)
        console.log("interceptor1"+user1)
        if(user1!=null)
        {
        const isLoggedIn = user1!.substring(8);
        console.log(isLoggedIn)
        //const isApiUrl = request.url.startsWith("http://localhost:8080");
        if (isLoggedIn ) {
            request = request.clone({
                setHeaders: {
                    Authorization:`Bearer ${isLoggedIn}`
                }
            });
            console.log(request)
        }
    }

         return next.handle(request);
    }
}