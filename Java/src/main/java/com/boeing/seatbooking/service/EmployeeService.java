package com.boeing.seatbooking.service;

import com.boeing.seatbooking.Entity.Employee;
import com.boeing.seatbooking.Repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    public Optional<Employee> getById(Integer id) {
            return  this.employeeRepository.findById(id);
    }

    // Update employee


    // save employee by ID


    public Employee saveEmployee(Employee emp) {
        return this.employeeRepository.save(emp);
    }


    public ResponseEntity<Employee> updateEmployee(int id, Employee emp) {
        Optional<Employee> exist=this.employeeRepository.findById(id);
        if(exist.isPresent()){
            Employee toUpdate=exist.get();
            toUpdate.setUsername(emp.getUsername());
            toUpdate.setEmailId(emp.getEmailId());
            toUpdate.setEmployeeId(emp.getEmployeeId());
            toUpdate.setPassword(emp.getPassword());
            toUpdate.setConfirm_Password(emp.getConfirm_Password());
            return ResponseEntity.ok(this.employeeRepository.save(toUpdate));
        }
        else
        {
            throw new MissingResourceException("abcd",Employee.class.getName(),"Id");
        }

    }

    public ResponseEntity<Employee> deleteEmployee(int id) {
        Optional<Employee> exist=this.employeeRepository.findById(id);
        if(exist.isPresent()){
            Employee toUpdate=exist.get();
            this.employeeRepository.delete(toUpdate);
            return ResponseEntity.noContent().build();
        }
        else
        {
            throw new MissingResourceException("abcd",Employee.class.getName(),"Id");
        }
    }

    public ResponseEntity<Employee> LoginEmployee(Employee emp) {
        Optional<Employee> exist=this.employeeRepository.findById(emp.getEmployeeId());
        if (exist.isPresent()){
            Employee e=exist.get();
            if (e.getPassword().equals(emp.getPassword()))
            {
                return ResponseEntity.ok(emp);
            }
        }
        return ResponseEntity.internalServerError().build();
    }

}