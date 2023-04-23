package com.springbootbackend.employee.service;


import java.util.List;


import org.springframework.stereotype.Service;

import com.springbootbackend.employee.dto.EmployeeDto;
import com.springbootbackend.employee.exception.ResourceNotFoundException;
import com.springbootbackend.employee.model.Employee;
import com.springbootbackend.employee.repository.EmployeeRepository;
import com.springbootbackend.mapper.EmployeeMapper;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ServiceEmployeeImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    

    @Override
    public List<Employee> findAllEmployees() {

         return  employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
       Employee employee = employeeRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id"+ id));
           
       return employee; 
        
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        // Convert EmployeeDto to JPA Entity
       Employee employee = EmployeeMapper.employeeDtoMapToEmployee(employeeDto);
       Employee savedEmployee = employeeRepository.save(employee);
       // Convert JPA Entity to EmployeeDto
       EmployeeDto savedEmployeeDto = EmployeeMapper.employeeMapToEmployeeDto(savedEmployee);
       return savedEmployeeDto;
    }

    @Override
    public EmployeeDto updateEmployeeById(Long id, EmployeeDto employeeDto) {

        // Getting Employee By Id
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id" + id));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmailId(employeeDto.getEmailId());
        // save employee
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert JPA Entity to EmployeeDto
        EmployeeDto savedEmployeeDto = EmployeeMapper.employeeMapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;

    }

 
    
}
