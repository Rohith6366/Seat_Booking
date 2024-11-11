package com.boeing.seatbooking.Repository;

import com.boeing.seatbooking.Entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor , Integer> {
}
