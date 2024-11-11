import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { BookingComponent } from './booking/booking.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { BookinghistoryComponent } from './bookinghistory/bookinghistory.component';


const routes: Routes = [
  {path :"home" ,component: HomeComponent},
  {path :"login" ,component: LoginComponent}, 
  {path :"signup" ,component: SignupComponent},
  {path :"adminlogin",component: AdminLoginComponent},
  {path :"booking",component: BookingComponent},
  {path :"profile",component: ProfileComponent},
  {path :"adminpage",component: AdminPageComponent},
  {path :"bookinghistory",component: BookinghistoryComponent},
  {path :"**" ,component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
