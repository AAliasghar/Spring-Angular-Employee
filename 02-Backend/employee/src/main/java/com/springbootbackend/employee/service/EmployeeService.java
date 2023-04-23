package com.springbootbackend.employee.service;

import java.util.List;

import com.springbootbackend.employee.dto.EmployeeDto;
import com.springbootbackend.employee.model.Employee;



public interface EmployeeService {
    List<Employee> findAllEmployees();
    Employee getEmployeeById(Long id);
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployeeById(Long id,EmployeeDto employeeDto);


}
