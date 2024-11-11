package com.boeing.seatbooking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tower {
    @Id
    @Column(name = "Tower_Name")
    private String towerName;

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }
}
