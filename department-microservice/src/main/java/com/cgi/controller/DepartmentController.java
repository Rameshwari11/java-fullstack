package com.cgi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.model.Department;
import com.cgi.repository.DepartmentRepository;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@GetMapping("/getAlldepartments")
	private ResponseEntity<?> getAllDepartments()
	{
		List<Department> result=departmentRepo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@GetMapping("/findDepartmentById/{Id}")
	private ResponseEntity<?> getAllDepartments(@PathVariable int Id)
	{
		Optional<Department> result=departmentRepo.findById(Id);
		if(result.isPresent()) {
		return ResponseEntity.status(HttpStatus.OK).body(result);
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	@PostMapping("/create/department")
	private ResponseEntity<?> createDepartment(@RequestBody Department department)
	{
		Department result = departmentRepo.save(department);	
		return ResponseEntity.status(HttpStatus.CREATED).body(result)	;
	}
	
	
	
}
