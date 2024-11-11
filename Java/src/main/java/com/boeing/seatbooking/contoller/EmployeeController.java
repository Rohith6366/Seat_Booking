
package com.boeing.seatbooking.contoller;


import com.boeing.seatbooking.Entity.Employee;
import com.boeing.seatbooking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAll();
    }


    //     Get employee by ID
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Integer id) {
        return this.employeeService.getById(id);
    }

    //     Create new employee
    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee emp) {
        return this.employeeService.saveEmployee(emp);
    }

    @PostMapping("/login")
    public ResponseEntity<Employee> LoginEmployee(@RequestBody Employee emp) {
        return this.employeeService.LoginEmployee(emp);
    }

    //     Update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
        try{
        return this.employeeService.updateEmployee(id,emp);}
        catch(MissingResourceException e){
        return ResponseEntity.notFound().build();
        }
    }

    // Delete employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        try{
            return this.employeeService.deleteEmployee(id);}
        catch(MissingResourceException e){
            return ResponseEntity.notFound().build();
        }
    }
}
