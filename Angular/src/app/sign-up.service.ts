import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  private _baseUrl = "http://localhost:8080"; 
  private user!: User; 

  constructor(private http: HttpClient) {}      //constructor for http client in sign up service service
  registerUser(users: User):Observable<User> { 
    console.log(users);                           //for debugging purpose
    return this.http.post<User>(`${this._baseUrl}/employees/add`, users); //base url from line 13 can be accessed here along with the mapping path from springboot
  }

//UserName
  setUserName(user: User) {
    console.log("Setting username in localStorage: " + user.username);
    localStorage.setItem("loggedInUserName", user.username);
  }
  getUserName(): string {
    const storedValue = localStorage.getItem("loggedInUserName");
    console.log("Stored Value: " + storedValue);
    return storedValue ? storedValue : "default-username";
}

//EmailID
  setEmailId(user: User) {
  console.log("Setting EmailId in localStorage: " + user.emailId);
  localStorage.setItem("loggedInEmailId", user.emailId);
}
  getEmailId(): string {
  const storedValue = localStorage.getItem("loggedInEmailId");
  console.log("Stored Value: " + storedValue);
  return storedValue ? storedValue : "default-username";
  
}

//Password
  setPassword(user: User) {
  console.log("Setting Password in localStorage: " + user.password);
  localStorage.setItem("loggedInPassword", user.password);
}
  getPassword(): string {
  const storedValue = localStorage.getItem("loggedInPassword");
  console.log("Stored Value: " + storedValue);
  return storedValue ? storedValue : "default-username";
}
}


