package com.cgi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cgi.model.Employee;
import com.cgi.repository.EmployeeRepository;
import com.cgi.service.EmployeeService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> result=employeeRepo.findAll();
		return result;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		Employee result = employeeRepo.save(employee);	
		return result;
	}

}
