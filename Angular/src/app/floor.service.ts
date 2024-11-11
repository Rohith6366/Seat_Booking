import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Floor } from './floor';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FloorService {

  private _baseUrl="http://localhost:8080"
  constructor(private http:HttpClient) { }

  floor(floors :Floor):Observable<Floor>{
    return this.http.post<Floor>(`${this._baseUrl}/floors/add`,floors)
  }
}
