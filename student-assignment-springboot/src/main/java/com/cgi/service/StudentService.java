package com.cgi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cgi.model.Student;

@Component
public interface StudentService {
	
	public Student createStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Optional<Student> findStudentById(int id);
	
	public List<Student> findByName(String name);
	
	public void deleteStudentById(int id);
	
	public void deleteAllStudent();
	
	

}
