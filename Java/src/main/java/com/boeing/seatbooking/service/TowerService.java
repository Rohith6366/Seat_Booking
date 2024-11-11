package com.boeing.seatbooking.service;

import com.boeing.seatbooking.Entity.Tower;
import com.boeing.seatbooking.Repository.TowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
@Service
public class TowerService {
    private TowerRepository towerRepository;

    public TowerService(TowerRepository towerRepository) {
        this.towerRepository = towerRepository;
    }

    public List<Tower> getAll() {
        return this.towerRepository.findAll();
    }

    public Tower saveTower(Tower tower) { return this.towerRepository.save(tower);
    }
}
