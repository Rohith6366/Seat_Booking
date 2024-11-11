package com.boeing.seatbooking.Repository;

import com.boeing.seatbooking.Entity.Tower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TowerRepository extends JpaRepository<Tower,Integer> {
}
