import { Component } from '@angular/core';
import { GlobalComponent } from './global';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'project';
  mainc:boolean = GlobalComponent.checkForNav;
  mainCheck:boolean=GlobalComponent.mainCheck;
}
