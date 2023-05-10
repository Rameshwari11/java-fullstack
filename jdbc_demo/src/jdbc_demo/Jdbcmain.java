package jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbcmain {

	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "ro", "root");
			if (connection != null) {
				System.out.println("sucessfully connected...");
			}
		} catch (Exception e) {
			System.out.println("Not sucessfully connected...");
			e.printStackTrace();
		}
	}
}
