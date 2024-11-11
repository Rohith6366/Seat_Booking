package com.boeing.seatbooking.contoller;

import com.boeing.seatbooking.Entity.Floor;
import com.boeing.seatbooking.service.FloorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/floors")
public class FloorController {
    private FloorService floorService;

    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }
    @GetMapping
    public List<Floor> getAllFloors() { return this.floorService.getAll();}

    @PostMapping("/add")
    public Floor createFloor(@RequestBody Floor floor) {return this.floorService.saveFloor(floor);}
}
