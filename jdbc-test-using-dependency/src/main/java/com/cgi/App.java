package com.cgi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.connection.ConnectionFactory;

public class App {
	public static void main(String[] args) {
		try {
			Connection connection=ConnectionFactory.getMySqlConnection();
			System.out.println("connection is succeed with mysql dependency ...!");

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select first_name,last_name,email from employees");
			System.out.println("first_name last_name email");
			
			while (resultSet.next())
			{
			System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name") + " "
						+ resultSet.getString("email"));
			}
		} 
		catch (Exception e) {
			System.out.println("connection not sucessfull.....");

		}

	}
}
