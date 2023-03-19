import { Injectable } from '@angular/core';
import { GlobalComponent } from './global';

@Injectable({
  providedIn: 'root'
})
export class GlobalVariableChangeService {

  check!:boolean;
  constructor(globalComponent : GlobalComponent) {
    this.check=globalComponent.checkForLogin;
   }
   change():void{
    this.check = false;
   }
}
