package com.boeing.seatbooking.service;

import com.boeing.seatbooking.Entity.Floor;
import com.boeing.seatbooking.Repository.FloorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloorService {
    private FloorRepository floorRepository;

    public FloorService(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    public List<Floor> getAll() {
        return this.floorRepository.findAll();
    }

    public Floor saveFloor(Floor floor) {
        return this.floorRepository.save(floor);
    }
}
