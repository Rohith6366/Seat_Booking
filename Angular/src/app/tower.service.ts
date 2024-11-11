import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tower } from './tower';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TowerService {
  private _baseUrl = "http://localhost:8080"
  constructor(private http: HttpClient) { }

  tower(towers: Tower):Observable<Tower>{
    return this.http.post<Tower>(`${this._baseUrl}/towers/add`,towers)
  }
}
