import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { LoginService } from '../login.service';
import { Login } from '../login';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  EmployeeId!:number;
  Password!:string;
  constructor(private loginservice:LoginService,private router :Router,private spinner: NgxSpinnerService)
  {}

  openScanner(){
    /** spinner starts on init */
    this.spinner.show();

    setTimeout(() => {
      /** spinner ends after 5 seconds */
      this.spinner.hide();
    }, 3000);
  }
  ngOnInit() {

  }
  LogInButton(){
    if(this.EmployeeId&&this.Password) //not be null
    {
      const l=new Login(this.EmployeeId,this.Password);
      this.loginservice.login(l).subscribe({
        next: (data) => {
          alert('Logged in successfully');
          this.loginservice.setuser(l);
          this.router.navigate(['booking']);
        },
        error:(error)=>{
          alert("Login Failed ! Please try Again");
        } 
      });
    }
    else {
      alert('Username and password are required');
    }
   
    
  }
}