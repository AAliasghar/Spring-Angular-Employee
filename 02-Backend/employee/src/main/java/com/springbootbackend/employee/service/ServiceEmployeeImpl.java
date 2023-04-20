package com.springbootbackend.employee.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootbackend.employee.dto.EmployeeDto;
import com.springbootbackend.employee.model.Employee;
import com.springbootbackend.employee.repository.EmployeeRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ServiceEmployeeImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {

         return  employeeRepository.findAll();
    }

 
    
}
