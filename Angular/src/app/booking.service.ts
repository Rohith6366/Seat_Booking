import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from './booking';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
 
  private _baseUrl = "http://localhost:8080";
  constructor(private http: HttpClient) {} 
  
  booking(bookings: Booking):Observable<Booking>{
    return this.http.post<Booking>(`${this._baseUrl}/bookings/add`,bookings);
  }
  getAllBookings(): Observable<Booking[]> {
    return this.http.get<Booking[]>(`${this._baseUrl}/bookings/getall`);
  }

  //SeatNo
    setSeatNo(seatno:Booking){
      console.log("Setting username in localStorage: " + seatno.seatno);
      localStorage.setItem("SeatNo", seatno.seatno.toString());
    }
    getSeatNo(): number {
      const storedValue = localStorage.getItem("SeatNo");
      console.log("Stored Value: " + storedValue);
      return parseInt(localStorage.getItem("SeatNo") || "0");
}
}
