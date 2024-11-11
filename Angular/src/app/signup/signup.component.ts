import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { SignUpService } from '../sign-up.service';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  EmployeeId!: number;
  EmailId!: string;
  UserName!: string;
  Password!: string;
  ConfirmPassword!: string;
  constructor(private signupservice: SignUpService, private router: Router,private spinner:NgxSpinnerService) {}

  openScanner(){
    /** spinner starts on init */
    this.spinner.show();

    setTimeout(() => {
      /** spinner ends after 5 seconds */
      this.spinner.hide();
    }, 3000);
  }

  ngOnInit() {}

  signUpButton() {
    if (
      this.EmployeeId &&
      this.EmailId &&
      this.UserName &&
      this.Password &&
      this.ConfirmPassword
    ) {
      if (this.Password === this.ConfirmPassword) {
        const user = new User(
          this.EmployeeId,
          this.EmailId,
          this.UserName,
          this.Password,
          this.ConfirmPassword
        );
        this.signupservice.registerUser(user).subscribe({
          next: (_) => {
            alert('Successfully registered! Redirecting to LoginPage');
            this.signupservice.setUserName(user);
            this.signupservice.setEmailId(user);
            this.signupservice.setPassword(user);
            this.router.navigate(['login']);
          },
          error: (err) => console.error(err)
        });
      } else {
        alert('Passwords do not match.');
      }
    } else {
      alert('Add Details in all the fields');
    }
  }
}
