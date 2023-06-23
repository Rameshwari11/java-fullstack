package com.cgi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cgi.dao.EmployeeDao;
import com.cgi.model.Employee;

@Component("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDao employeeDao;

	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee createEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		return employeeDao.createEmployee(employee);
	}

	@Override
	public void findEmployeeById(int employeeId) throws SQLException {
		employeeDao.findEmployeeById(employeeId);
		
	}

	@Override
	public void deleteEmployeeById(int employeeId) throws SQLException {
		employeeDao.deleteEmployeeById(employeeId);
		
	}

}
