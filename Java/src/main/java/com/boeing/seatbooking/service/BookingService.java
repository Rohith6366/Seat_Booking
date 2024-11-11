package com.boeing.seatbooking.service;

import com.boeing.seatbooking.Entity.Booking;
import com.boeing.seatbooking.Repository.BookingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service
public class BookingService {


    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAll() {
        return this.bookingRepository.findAll();

    }
    public Optional<Booking> getById(Integer id) { return this.bookingRepository.findById(id);
    }

    public Optional<Booking> getBooking(String towerName, String floorName, int seatNo) {
        return this.bookingRepository.findByTowerNameAndFloorNameAndSeatno(towerName, floorName, seatNo);
    }

    public Booking saveBooking(Booking booking) throws Exception{
        var existingBooking = this.bookingRepository.findByTowerNameAndFloorNameAndSeatno(booking.getTowerName(), booking.getFloorName(), booking.getSeatno());

        if(existingBooking.isEmpty())
            return this.bookingRepository.save(booking);
        else
            throw new Exception("Booking exists");
    }


    public ResponseEntity<Booking> updateBooking(int id, Booking booking) {
        Optional<Booking> exist = this.bookingRepository.findById(id);
        if (exist.isPresent()) {
            Booking toUpdate = exist.get();
            toUpdate.setEmployeeId(booking.getEmployeeId());
            toUpdate.setSeatno(booking.getSeatno());
            toUpdate.setFloorName(booking.getFloorName());
            toUpdate.setTowerName(booking.getTowerName());
            toUpdate.setBookingDate(booking.getBookingDate());

            return ResponseEntity.ok(this.bookingRepository.save(toUpdate));
        } else {
            throw new MissingResourceException("abcd", Booking.class.getName(), "Id");
        }
    }

    public ResponseEntity<Booking> deleteBooking(int id) {
        Optional<Booking> exist = this.bookingRepository.findById(id);
        if (exist.isPresent()) {
            Booking toUpdate = exist.get();
            this.bookingRepository.delete(toUpdate);
            return ResponseEntity.noContent().build();
        } else {
            throw new MissingResourceException("abcd", Booking.class.getName(), "Id");
        }
    }


}



