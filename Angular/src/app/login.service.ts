import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from './login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private _baseUrl = "http://localhost:8080"; // Make sure this is the correct API endpoint
  private user!: Login;

  constructor(private http: HttpClient) {}

  login(l:Login): Observable<any> {
    return this.http.post<any>(`${this._baseUrl}/employees/login`,l);
  }

  //UserID
  setuser(user:Login){
    this.user = user;
    localStorage.setItem("loggedInUserId", user.employeeId.toString())
  }

  getId():number{
    return parseInt(localStorage.getItem("loggedInUserId") || "0");
  }
}
