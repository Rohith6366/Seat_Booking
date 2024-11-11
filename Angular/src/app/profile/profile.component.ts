import { Component } from '@angular/core';
import { SignUpService } from '../sign-up.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  EmployeeId:number =  this.loginservie.getId();                                                  
  EmailId:string =this.signupservice.getEmailId();
  UserName:string= this.signupservice.getUserName();
  Password:string=this.signupservice.getPassword();
  constructor(private signupservice:SignUpService,private loginservie:LoginService){} //use router for previewing login page
}
