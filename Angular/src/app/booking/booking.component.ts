import { Component, OnInit } from '@angular/core';
import { BookingService } from '../booking.service';
import { Booking } from '../booking';
import { LoginService } from '../login.service';
import { SignUpService } from '../sign-up.service';
import { User } from '../user';
import { HttpClient } from '@angular/common/http';
import { Tower } from '../tower';
import { Floor } from '../floor';
import { MatDialog } from '@angular/material/dialog';
import { PopupComponent } from '../popup/popup.component';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  EmployeeId!:number;
  SeatNo!:number;
  TowerName!:string;
  FloorName!:string;
  BookingDate!:Date;
  BookingId!:number;
  towerNames: string[] = [];
  floorNumbers: string[] = []; 
  EmailID:string=this.signupservice.getEmailId();
  Username: string = this.signupservice.getUserName(); // Initialize with your desired username
  selectedSeat: HTMLElement | null = null;
  constructor(private bookingservice:BookingService, private loginService: LoginService,private signupservice:SignUpService,private http:HttpClient,private dialog:MatDialog){}

  ngOnInit() {
    const seats = document.querySelectorAll('.seat');
    this.fetchTowerData()
    this.fetchFloorData()
    seats.forEach(seat => {
      seat.addEventListener('click', () => {
        if (this.selectedSeat) {
          this.selectedSeat.classList.remove('selected');
        }
        this.selectedSeat = seat as HTMLElement; // Cast 'seat' to 'HTMLElement'
        this.selectedSeat.classList.add('selected');
      });
    });
  }
  fetchTowerData() {

    this.http.get<Tower[]>('http://localhost:8080/towers').subscribe(

      (data) => {

        console.log(data);

        this.towerNames = data.map(item => item.towerName);

      },

      (error) => {

        console.error('Error fetching tower data:', error);

      }

    );

  }  
  fetchFloorData() {

    this.http.get<Floor[]>('http://localhost:8080/floors').subscribe(

      (data) => {

        console.log(data);

        this.floorNumbers = data.map(item => item.floorName);

      },

      (error) => {

        console.error('Error fetching tower data:', error);

      }

    );

  } 
  bookingButton(){
    this.EmployeeId = this.loginService.getId();
    this.Username=this.signupservice.getUserName();
    this.EmailID=this.signupservice.getEmailId();

    if(this.EmployeeId&&this.SeatNo&&this.TowerName&&this.FloorName&&this.BookingDate)
    {
      const booking=new Booking(this.BookingId,this.EmployeeId,this.SeatNo,this.TowerName,this.FloorName,this.BookingDate);
      
      this.bookingservice.booking(booking).subscribe({
        next:(_)=>{
          
          alert("Your Seat has been Booked ! Happy Booking")
          
          // this.router.navigate(['login']); router logic

        },error:(err)=>{
          alert(err.error);
      } 
      });
    }
    else{
      alert("Please select a seat and fill in all the required fields");
    }
  }
  onSeatClick(seat: HTMLElement): void {
    const seatNumber = seat.innerText;
    this.SeatNo = parseInt(seatNumber);
    // Do something with the seat number, such as storing it in a variable or sending it to your server.
  }
  openpopup(){
    this.dialog.open(PopupComponent,{
    width:'500px',
    height:'400px',
    enterAnimationDuration:'1000ms',
    exitAnimationDuration:'1000ms',
      })
}
}
