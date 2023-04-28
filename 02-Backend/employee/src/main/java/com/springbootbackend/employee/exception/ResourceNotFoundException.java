package com.springbootbackend.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final Long serialVersionUID = 1L;
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String resouceName, String fieldName, Long fieldValue) {
        super(String.format("%S not found with %S : %S'", resouceName,fieldName,fieldValue));
        this.resourceName =resouceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
