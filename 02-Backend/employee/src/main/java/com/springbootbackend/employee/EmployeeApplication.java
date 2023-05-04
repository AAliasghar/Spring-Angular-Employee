package com.springbootbackend.employee;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Spring Boot API Documentation",
 					description = "Spring Boot API Documentation", version = "v1.0",
  					contact = @Contact(name = "AAliasghar", 
  					url = "https://github.com/AAliasghar/Spring-Angular-Employee")
  ),
  	 externalDocs = @ExternalDocumentation(description = "Spring Boot Employee Management Documentation",
   										 url = "https://github.com/AAliasghar/Spring-Angular-Employee"))
public class EmployeeApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
