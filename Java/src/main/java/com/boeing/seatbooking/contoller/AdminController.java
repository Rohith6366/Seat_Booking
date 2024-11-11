package com.boeing.seatbooking.contoller;

import com.boeing.seatbooking.Entity.Admin;
import com.boeing.seatbooking.Entity.Employee;
import com.boeing.seatbooking.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {


    private AdminService adminService;

    public AdminController(AdminService adminService) { this.adminService = adminService; }

    // Get all employees
    @GetMapping
    public List<Admin> getAllEmployees() {
        return this.adminService.getAll();
    }
    // Get admin by ID
    @GetMapping("/{id}")
    public Optional<Admin> getAdminById(@PathVariable int id) {
        return this.adminService.getById(id);
    }

    // Create new admin
    @PostMapping("/add")
    public Admin createAdmin(@RequestBody Admin admin) {
        return this.adminService.saveAdmin(admin);
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> LoginAdmin(@RequestBody Admin admin) {
        return this.adminService.LoginAdmin(admin);
    }
    // Update admin
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin ) {
        try {
            return this.adminService.updateAdmin(id,admin);}
        catch (MissingResourceException e){
            return ResponseEntity.notFound().build();
        }
    }

    // Delete admin by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable int id) {
        try{
            return this.adminService.deleteAdmin(id);}
        catch(MissingResourceException e){
            return ResponseEntity.notFound().build();
        }
    }
}