package com.cgi;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cgi.config.SpringConfig;
import com.cgi.model.Employee;
import com.cgi.service.EmployeeService;

public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main( String[] args )
    {
    	ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
      	EmployeeService employeeService = context.getBean("EmployeeService",EmployeeService.class);
      	int choice = 0;

		do {
			System.out.println("1. Create New employee.");
			System.out.println("2. Display all Available employee.");
			System.out.println("3. Find A employee By employee ID.");
			System.out.println("4. Delete employee By employee ID.");
			System.out.print("Enter Your Choice: ");
			
			choice = scanner.nextInt();

			
			switch (choice) {
			case 1:
				  System.out.print("Enter First Name: ");
					String fName = scanner.next();
					System.out.print("Enter Last Name: ");
					String lName = scanner.next();
					System.out.print("Enter Email: ");
					String email = scanner.next();
					Employee employee;
					try {
						employee = employeeService
								.createEmployee(new Employee(new Random().nextInt(1000), fName, lName, email));
						System.out.println("Employee Created: " + employee);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
			
    	
		case 2:
			 try {
		          	List<Employee> list=employeeService.getAllEmployees();
		          	for(Employee c:list)
		          	{
		          	  System.out.println(c);	
		          	}    	
		  		} catch (Exception e) {
		  			e.printStackTrace();
		  		}
			 break;
		case 3:
			System.out.print("enter id: ");
			int id = scanner.nextInt();
				try {
					employeeService.findEmployeeById(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
		case 4:

			System.out.print("enter id: ");
			
				
					try {
						id = scanner.nextInt();
						employeeService.deleteEmployeeById(id);
					} catch(InputMismatchException e1)
					{
						System.out.println("Input is not integer");
					}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
      }
    } while (choice != 0);
    }
	
	
}
