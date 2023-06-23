package com.cgi.dao;

import java.util.List;

import com.cgi.model.Student;

public interface StudentDao {
	
	public List<Student> getAllStudents();
	
	public Student createStudent(Student student);
	
	public Student getStudentById(int id);
	
	public Student updateStudent(int studentId, Student student);
	
	public void deleteStudentById(int id);
	
	public void deleteAllStudents();
	
	

}
