package com.cgi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.model.Employee;

@Component("EmployeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	private final DataSource dataSource;
	
	

	@Autowired
	public EmployeeDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> list = new ArrayList<>();
		try {
			Connection connection=dataSource.getConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from employee");
			while(resultSet.next())
			{
			 list.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					 resultSet.getString(4)));	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
	}
	
	@Override
	public Employee createEmployee(Employee employee) throws SQLException {
		
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?)");
		preparedStatement.setInt(1, employee.getEmployeeId());
		preparedStatement.setString(2, employee.getFirstName());
		preparedStatement.setString(3, employee.getLastName());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.executeUpdate();
		return employee;
	}

	@Override
	public void findEmployeeById(int employeeId) throws SQLException {
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where employee_Id = ?");
		preparedStatement.setInt(1, employeeId);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			System.out.println("found.");
			System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " "
					+ resultSet.getString(4));
		} else {
			System.out.println("not found.");
		}
		
	}


	@Override
	public void deleteEmployeeById(int employeeId) throws SQLException {
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete  from employee where employee_id=?");
		preparedStatement.setInt(1, employeeId);
		int count = preparedStatement.executeUpdate();
		if (count > 0) {
			System.out.println("employee with " + employeeId + " removed sucessfully...");
		} else {
			System.out.println("no such record found........!!");
		}
		
	}
	
	

	

}
