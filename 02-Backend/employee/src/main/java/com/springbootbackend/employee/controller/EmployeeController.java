package com.springbootbackend.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbackend.employee.exception.ResourceNotFoundException;
import com.springbootbackend.employee.model.Employee;
import com.springbootbackend.employee.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all Employess
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee By Id
    @GetMapping("/employees/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable Long id){
        Employee employee= employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id"+id));
        return  new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    // Create/Save Employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // Update Employee
    // @PostMapping
    // public 

    // public Employee

}
