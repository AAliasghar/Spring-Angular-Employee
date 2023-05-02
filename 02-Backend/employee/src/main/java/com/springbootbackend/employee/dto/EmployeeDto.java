package com.springbootbackend.employee.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {

    private Long id;
    @NotEmpty(message = "Employee First Name should not be empty")
    private String firstName;
    @NotEmpty(message = "Employee Last Name should not be empty")
    private String lastName;
    @NotEmpty(message = "Employee Email should not be empty")
    @Email(message = "Email should be valid")
    private String emailId;

}
