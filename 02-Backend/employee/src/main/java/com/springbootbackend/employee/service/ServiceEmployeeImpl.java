package com.springbootbackend.employee.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootbackend.employee.model.Employee;

@Service
public class ServiceEmployeeImpl implements EmployeeService{

    @Override
    public List<Employee> findAllEmployees() {
        
        throw new UnsupportedOperationException("Unimplemented method 'findAllEmployees'");
    }

 
    
}
