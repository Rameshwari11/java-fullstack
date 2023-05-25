package com.cgi;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.cgi.config.SpringConfig;
import com.cgi.model.Student;
import com.cgi.service.StudentServiceImpl;

public class App 
{
    static Scanner scanner = new Scanner(System.in);
    public static void main( String[] args )
    {
    	int choice=0; 	
        do { 	
        	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        	StudentServiceImpl studentService = context.getBean("studentService",StudentServiceImpl.class);
        		
        	System.out.println("1. Create Student ");
			System.out.println("2. View All Students ");
			System.out.println("3. Find Student By StudentID");
			System.out.println("4. Find Student By StudentName");
			System.out.println("5. Find Student By Date");
			System.out.println("6. Delete Student by StudentID");
			System.out.println("7. Delete All Students");
			System.out.println("8. Update Student By StudentID");
			System.out.println("9. Update Student By StudentName");
			System.out.println();
			System.out.println("Choose any 1 of the given options :");
			choice = scanner.nextInt();	
			int studentId ;	
			
			switch (choice) {
			case 1:
				 studentId = new Random().nextInt(200);
				 System.out.println("Enter Name:"); 
				 String name = scanner.next(); 
				 System.out.println("Enter EnteringDate:"); 
				 String date = scanner.next();
				 System.out.println("Enter Nationality:"); 
				 String nationality = scanner.next();
				 System.out.println("Enter code:"); 
				 String code = scanner.next(); 
				 Student student = new Student( name, date, nationality, code);
				 studentService.createStudent(student); 
				 System.out.println("Student created : "+student);  
				 break;
				 
			case 2:
				List<Student> studentsList = studentService.getAllStudents();
						if(studentsList.isEmpty()) {
					System.out.println("No Student Found");
				}
		        for(Student s:studentsList)
		        {
		        	System.out.println(s);
		        }
				break;
				
			case 3:	
				System.out.println("Enter Student Id :");
				studentId = scanner.nextInt();
				Student result = studentService.findStudentById(studentId);
				break;
				
			case 4:	
				System.out.println("Enter Student Name :");
				String studentName = scanner.next();
				Student result2 = studentService.findStudentByName(studentName);
				break;
				
			case 5:	
				System.out.println("Enter Entry Date :");
				String entryDate = scanner.next();
				Student result3 = studentService.findStudentByDate(entryDate);
				break;
			
			case 6:
				System.out.println("Enter Student Id to delete :");
				studentId = scanner.nextInt();
				studentService.deleteStudentById(studentId);
			break;
			
			case 7:
				studentService.deleteAllStudents();
				System.out.println("Deleted All Students...");
				break;
				
			case 8:
				 System.out.println("Enter Student Id to update:"); 
				 studentId = scanner.nextInt(); 
				 System.out.println("Enter Name:"); 
				 String name1 = scanner.next();
				 System.out.println("Enter EnteringDate:"); 
				 String date1 = scanner.next();
				 System.out.println("Enter Nationality:"); 
				 String nationality1 = scanner.next(); 
				 System.out.println("Enter code:"); 
				 String code1 = scanner.next();
			 
				 Student updateStudent = new Student( name1, date1, nationality1, code1);
				 studentService.updateStudentById(studentId, updateStudent);
				 System.out.println("Student updated successfully:"+updateStudent); 
				 break;
			
			case 9:
				 System.out.println("Enter Student Name to update:"); 
				 String name2 = scanner.next();
				 System.out.println("Enter EnteringDate:"); 
				 String date2 = scanner.next();
				 System.out.println("Enter Nationality:"); 
				 String nationality2 = scanner.next();
				 System.out.println("Enter code:"); 
				 String code2 = scanner.next();
				 
				 Student updateStudent2 = new Student( name2, date2, nationality2, code2);
				 studentService.updateStudentByName(name2, updateStudent2);
				 System.out.println("Student updated successfully:"+updateStudent2); 
				 break;
		
			}
        }while(choice != 0);
        
        } 
	}


