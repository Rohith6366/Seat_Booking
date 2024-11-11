package com.boeing.seatbooking.Entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Booking {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name= "Booking_Id")
  private int bookingId;

  public int getBookingId() {
    return bookingId;
  }

  public void setBookingId(int bookingId) {
    this.bookingId = bookingId;
  }

  @Column(name = "Employee_Id")
  private int employeeId;



  @Column(name = "Seat_no")
  private int seatno;

  @Column(name = "Tower_Name")
  private String towerName;

  @Column(name = "Floor_Name")
  private String floorName;

  @Column(name = "Booking_Date")
  private Date bookingDate;



  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public int getSeatno() {
    return seatno;
  }

  public void setSeatno(int seatno) {
    this.seatno = seatno;
  }

  public String getTowerName() {
    return towerName;
  }

  public void setTowerName(String towerName) {
    this.towerName = towerName;
  }

  public String getFloorName() {
    return floorName;
  }

  public void setFloorName(String floorName) {
    this.floorName = floorName;
  }

  public Date getBookingDate() { return bookingDate;
  }

  public void setBookingDate(Date bookingDate) {
    this.bookingDate = bookingDate;
  }


}
