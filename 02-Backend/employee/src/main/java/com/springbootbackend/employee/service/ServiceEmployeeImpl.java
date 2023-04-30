package com.springbootbackend.employee.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springbootbackend.employee.dto.EmployeeDto;
import com.springbootbackend.employee.exception.EmailAlreadyExistException;
import com.springbootbackend.employee.exception.ResourceNotFoundException;
import com.springbootbackend.employee.model.Employee;
import com.springbootbackend.employee.repository.EmployeeRepository;
import com.springbootbackend.mapper.AutoEmployeeMapper;
import com.springbootbackend.mapper.EmployeeMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceEmployeeImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public List<Employee> findAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        return employee;

    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Optional<Employee> emOptional = employeeRepository.findByEmailId(employeeDto.getEmailId());

        if (emOptional.isPresent()) {
            throw new EmailAlreadyExistException("Email Already Exist for Employee");

        }

        // Convert EmployeeDto to JPA Entity
        // Employee employee = EmployeeMapper.employeeDtoMapToEmployee(employeeDto);
        // Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);
        // Convert JPA Entity to EmployeeDto
        // EmployeeDto savedEmployeeDto =
        // EmployeeMapper.employeeMapToEmployeeDto(savedEmployee);
        // EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee,
        // EmployeeDto.class);
        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto updateEmployeeById(Long id, EmployeeDto employeeDto) {

        // Getting Employee By Id
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmailId(employeeDto.getEmailId());
        // save employee
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert JPA Entity to EmployeeDto
        // EmployeeDto savedEmployeeDto =
        // EmployeeMapper.employeeMapToEmployeeDto(savedEmployee);
        // EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee,
        // EmployeeDto.class);
        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;

    }

    @Override
    public Map<String, Boolean> deleteEmployeeById(Long id) {
        // Getting Employee By Id
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        // Delete Employee
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
