package com.springbootbackend.employee.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import com.springbootbackend.employee.model.Employee;
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

    // Create Save Employee
    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        EmployeeDto savedEmployeeDto = serviceEmployeeImpl.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    // Update Employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long id,
            @RequestBody @Valid EmployeeDto employeeDetails) {
        EmployeeDto updatedEmployeeDto = serviceEmployeeImpl.updateEmployeeById(id, employeeDetails);
        return new ResponseEntity<>(updatedEmployeeDto, HttpStatus.OK);

    }

    // Delete Employee By Id
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable Long id) {
        Map<String, Boolean> response = serviceEmployeeImpl.deleteEmployeeById(id);

        return ResponseEntity.ok(response);

    };

}
