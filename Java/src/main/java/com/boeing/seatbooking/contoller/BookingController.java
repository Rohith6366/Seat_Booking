package com.boeing.seatbooking.contoller;

import com.boeing.seatbooking.Entity.Booking;
import com.boeing.seatbooking.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
 public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

   @GetMapping("/getall")
   public List<Booking> getAllBookings() { return this.bookingService.getAll();}
    // Get booking by ID
    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable int id) {
        return this.bookingService.getById(id);
    }

    // Create new booking
    @PostMapping("/add")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        var existingBooking = this.bookingService.getBooking(booking.getTowerName(), booking.getFloorName(), booking.getSeatno());

        try {
            return ResponseEntity.ok(this.bookingService.saveBooking(booking));
        }
        catch (Exception e){
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return new ResponseEntity<>("Seat is already booked!", HttpStatus.BAD_REQUEST);
        }
    }

    // Update booking
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        try{
            return this.bookingService.updateBooking(id,booking);}
        catch(MissingResourceException e){
            return ResponseEntity.notFound().build();
        }

    }

    // Delete booking by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable int id) {
     try{
         return this.bookingService.deleteBooking(id);}
     catch (MissingResourceException e){
         return ResponseEntity.notFound().build();
     }
    }
}