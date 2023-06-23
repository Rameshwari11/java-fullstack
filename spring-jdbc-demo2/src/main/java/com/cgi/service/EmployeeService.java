package com.cgi.service;

import java.sql.SQLException;
import java.util.List;

import com.cgi.model.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee) throws SQLException;
	
	public List<Employee> getAllEmployees();
	public void findEmployeeById(int employeeId) throws SQLException;
	public void deleteEmployeeById(int employeeId) throws SQLException;

}
