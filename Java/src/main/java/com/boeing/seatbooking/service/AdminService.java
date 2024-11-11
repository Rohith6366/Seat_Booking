package com.boeing.seatbooking.service;


import com.boeing.seatbooking.Entity.Admin;
import com.boeing.seatbooking.Entity.Employee;
import com.boeing.seatbooking.Repository.AdminRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service
public class AdminService {


    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAll() {
        return this.adminRepository.findAll();
    }


    // Get admin by ID
    public Optional<Admin> getById(Integer id) {
        return this.adminRepository.findById(id);
    }

    // Save admin
    public Admin saveAdmin(Admin admin) {
        return this.adminRepository.save(admin);
    }








    public ResponseEntity<Admin> updateAdmin(int id, Admin admin) {
        Optional<Admin> exist = this.adminRepository.findById(id);
        if (exist.isPresent()) {
            Admin toUpdate = exist.get();
            toUpdate.setAdminId(admin.getAdminId());
            toUpdate.setAdminPassword(admin.getAdminPassword());

            return ResponseEntity.ok(this.adminRepository.save(toUpdate));
        } else {
            throw new MissingResourceException("abcd", Admin.class.getName(), "Id");
        }

    }

    public ResponseEntity<Admin> deleteAdmin(int id) {
        Optional<Admin> exist = this.adminRepository.findById(id);
        if (exist.isPresent()) {
            Admin toUpdate = exist.get();
            this.adminRepository.delete(toUpdate);
            return ResponseEntity.noContent().build();
        } else {
            throw new MissingResourceException("abcd", Admin.class.getName(), "Id");
        }
    }



    public ResponseEntity<Admin>LoginAdmin(Admin admin) {
        Optional<Admin> exist =this.adminRepository.findById(admin.getAdminId());
        if(exist.isPresent()) {
            Admin a = exist.get();
            if(a.getAdminPassword().equals(admin.getAdminPassword())) {
            return ResponseEntity.ok(admin);
}
}
            return ResponseEntity.internalServerError().build();
    }





}




