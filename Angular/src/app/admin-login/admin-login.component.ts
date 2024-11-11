import { Component, OnInit } from '@angular/core';
import { AdminloginService } from '../adminlogin.service';
import { Admin } from '../admin';
import { Router } from '@angular/router';
import { NgxSpinner, NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit{
  AdminId!:number;
  AdminPassword!:string;
  constructor(private adminloginservice:AdminloginService,private router:Router,private spinner:NgxSpinnerService)
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
  AdminLogInButton(){
    if(this.AdminId&&this.AdminPassword)
    {
      const a=new Admin(this.AdminId,this.AdminPassword);
      this.adminloginservice.adminlogin(a).subscribe({
      next: (data) => {
        console.log(a)
        alert('Logged in successfully');
        this.router.navigate(['adminpage']);
        },
      error:(error)=>{
        alert("Enter Correct Credentials");
        } 
      });
    }
  else {
    alert('AdminId and password are required');
    }
}
}

