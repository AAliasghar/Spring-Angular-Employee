package com.springbootbackend.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbackend.employee.dto.EmployeeDto;
import com.springbootbackend.employee.exception.ResourceNotFoundException;
import com.springbootbackend.employee.model.Employee;
import com.springbootbackend.employee.repository.EmployeeRepository;
import com.springbootbackend.employee.service.ServiceEmployeeImpl;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class EmployeeController {

    
    private ServiceEmployeeImpl serviceEmployeeImpl;

    // Get all Employess
    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return serviceEmployeeImpl.findAllEmployees();
    }

   // Get Employee By Id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = serviceEmployeeImpl.getEmployeeById(id);    
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    // // Create/Save Employee
    // @PostMapping("/employees")
    // public Employee createEmployee(@RequestBody Employee employee) {
    //     return employeeRepository.save(employee);
    // }

    // // Update Employee
    // @PutMapping("/employees/{id}")
    // public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employeeDetails) {

    //     // Getting Employee By Id
    //     Employee employee = employeeRepository.findById(id)
    //             .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id" + id));
    //     // Updating new details
    //     employee.setFirstName(employeeDetails.getFirstName());
    //     employee.setLastName(employeeDetails.getLastName());
    //     employee.setEmailId(employeeDetails.getEmailId());

    //     // save employee
    //     Employee updatedEmployee = employeeRepository.save(employee);
    //     return ResponseEntity.ok(updatedEmployee);
    // }

    // // Delete Employee By Id
    // @DeleteMapping("/employees/{id}")
    // public ResponseEntity<Map<String, Boolean>> deleteEmployeeById( @PathVariable Long id) {
    //     // Getting Employee By Id
    //     Employee employee = employeeRepository.findById(id)
    //             .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id" + id));
    //     // Delete Employee
    //     employeeRepository.delete(employee);
    //     Map<String,Boolean> response = new HashMap<>();
    //     response.put("deleted", Boolean.TRUE);
    //     return ResponseEntity.ok(response);
               
    // };

    }


