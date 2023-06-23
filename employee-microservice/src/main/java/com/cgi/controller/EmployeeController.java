package com.cgi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cgi.model.Department;
import com.cgi.model.Employee;
import com.cgi.model.Error;
import com.cgi.service.impl.EmployeeServiceImpl;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@ExceptionHandler(value = HttpClientErrorException.class)	
	public ResponseEntity<Error> handleException(HttpClientErrorException e)
	{
		Error error=new Error(HttpStatus.NOT_FOUND.value(),"DepartmentID is Not Found",System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@GetMapping("/getAllEmployees")
	private ResponseEntity<?> getAllDepartments()
	{
		List<Employee> result=employeeServiceImpl.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@PostMapping("/createEmployee")
	private ResponseEntity<?> createDepartment(@RequestBody Employee employee) throws HttpClientErrorException
	{
		Department department = restTemplate.getForObject("http://localhost:8083/department-microservice/findDepartmentById/{employeeId}",Department.class, Map.of("employeeId",employee.getDepartmentId()));
		employee.setDepartmentName(department.getDepartmentName());
		employee.setDepartmentLocation(department.getDepartmentLocation());
		Employee result = employeeServiceImpl.createEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(result)	;
	}
}
