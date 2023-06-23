package com.cgi.service;

import java.util.List;

import com.cgi.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	
	public Employee createEmployee(Employee employee);
}
