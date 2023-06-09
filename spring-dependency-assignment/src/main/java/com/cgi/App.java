package com.cgi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Employee myEmployee = context.getBean("employee", Employee.class);
		System.out.println(myEmployee);

		Employee myEmployee1 = context.getBean("employee", Employee.class);
		System.out.println(myEmployee1);

		System.out.println(myEmployee == myEmployee1);
	}
}
