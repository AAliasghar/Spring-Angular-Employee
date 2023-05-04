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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "CRUD REST APIs for Employee Resourse", description = "CRUD APIs - Create Employee, Update Employee, Get Employee, Get All Employees, Delete Employee")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class EmployeeController {

    private ServiceEmployeeImpl serviceEmployeeImpl;


    @Operation(summary = "Get All Employee REST API",
                 description = "Get All Employee REST API is used to get all Employee from database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    // Get all Employess
    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return serviceEmployeeImpl.findAllEmployees();
    }

    @Operation(summary = "Get Employee By ID REST API",
                 description = "Get Employee By ID REST API is used to get an Employee from database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    // Get Employee By Id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = serviceEmployeeImpl.getEmployeeById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @Operation(summary = "Create Employee REST API", description = "Create Employee REST API is used to save Employee in database")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    // Create Save Employee
    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        EmployeeDto savedEmployeeDto = serviceEmployeeImpl.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @Operation(summary = "Update Employee By ID REST API", description = "Update Employee By ID REST API is used to update an Employee in the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    // Update Employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long id,
            @RequestBody @Valid EmployeeDto employeeDetails) {
        EmployeeDto updatedEmployeeDto = serviceEmployeeImpl.updateEmployeeById(id, employeeDetails);
        return new ResponseEntity<>(updatedEmployeeDto, HttpStatus.OK);

    }

    @Operation(summary = "Delete Employee By ID REST API", description = "Delete an Employee REST API is used to delete an Employee from database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    // Delete Employee By Id
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable Long id) {
        Map<String, Boolean> response = serviceEmployeeImpl.deleteEmployeeById(id);

        return ResponseEntity.ok(response);

    };

}
