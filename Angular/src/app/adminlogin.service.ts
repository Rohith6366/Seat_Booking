import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class AdminloginService {
  private _baseUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  adminlogin(a:Admin): Observable<any> {
    console.log(a)
    return this.http.post<any>(`${this._baseUrl}/admins/login`,a);
}
}
