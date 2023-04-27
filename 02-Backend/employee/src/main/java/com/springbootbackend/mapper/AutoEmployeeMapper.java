package com.springbootbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springbootbackend.employee.dto.EmployeeDto;
import com.springbootbackend.employee.model.Employee;

@Mapper
public interface AutoEmployeeMapper {

    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    // Convert JPA Entity to EmployeeDto
    public EmployeeDto mapToEmployeeDto(Employee employee);
    
    // Convert EmployeeDto to JPA Entity 
    public Employee mapToEmployee(EmployeeDto employeeDto);

    
}
