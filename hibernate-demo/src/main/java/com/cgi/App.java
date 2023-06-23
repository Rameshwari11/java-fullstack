package com.cgi;

import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.cgi.model.Student;
import com.cgi.service.StudentService;
import com.cgi.service.StudentServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		  SessionFactory factory=new
		  Configuration().configure().addAnnotatedClass(Student.class). buildSessionFactory();
		  Session session=factory.openSession();
		  
		  session.getTransaction().begin(); 
		  
		  session.save(new Student(200, "Marry", "Public", "marry@email.com")); 
		  System.out.println("student created...");
		  
		  Query query=session.createQuery("FROM Student"); 
		  java.util.List<Student>students= query.getResultList(); for(Student s:students) {
		  System.out.println(s); }
		  
		  System.out.print("Enter Student ID: ");
		  
		  int id=scanner.nextInt();
		  
		  Student student=session.find(Student.class, id);
		  
		  if(student==null) { 
			  System.out.println("no such student found.."); 
			  } else {
		  System.out.println("Found: "+student);
		  }
		  
		  session.getTransaction().commit();
		 

		StudentService studentService = new StudentServiceImpl();

		Student student1 = new Student(211, "Marry", "kom", "kom@email.com");
		// studentService.createStudent(student1);
		// studentService.deleteStudentById(100);
		// studentService.deleteAllStudents();
		// Student s=studentService.updateStudent(100, new Student("John", "Doe",
		// "john@email.com"));
		// System.out.println(studentService.getAllStudent());

		studentService.getStudentById(200);

	}
}
