package com.springbootbackend.mapper;

import com.springbootbackend.employee.dto.EmployeeDto;
import com.springbootbackend.employee.model.Employee;

public class EmployeeMapper {

    // Convert JPA Entity to EmployeeDto
    public static EmployeeDto employeeMapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmailId()
        );
        return employeeDto;
    }
    
    // Convert EmployeeDto to JPA Entity
    public static Employee employeeDtoMapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee(
          //  employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmailId()
        );
        return employee;
    } 
}
