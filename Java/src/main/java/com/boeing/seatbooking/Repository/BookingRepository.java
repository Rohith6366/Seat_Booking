package com.boeing.seatbooking.Repository;


import com.boeing.seatbooking.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    public Optional<Booking> findByTowerNameAndFloorNameAndSeatno(String towerName, String floorName, int seatNo);
}
