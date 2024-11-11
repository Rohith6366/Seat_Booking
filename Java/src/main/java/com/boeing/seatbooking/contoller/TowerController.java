package com.boeing.seatbooking.contoller;

import com.boeing.seatbooking.Entity.Tower;
import com.boeing.seatbooking.service.TowerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/towers")
@CrossOrigin(origins = "http://localhost:4200")
public class TowerController {
    private TowerService towerService;
    public TowerController(TowerService towerService) {
        this.towerService = towerService;
    }
    @GetMapping
    public List<Tower> getAllTowers(){return this.towerService.getAll();}

    @PostMapping("/add")
    public Tower createTower(@RequestBody Tower tower){return this.towerService.saveTower(tower);}


}
