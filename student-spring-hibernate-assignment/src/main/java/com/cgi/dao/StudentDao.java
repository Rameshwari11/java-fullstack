package com.cgi.dao;

import java.util.List;

import com.cgi.model.Student;

public interface StudentDao {
	
	public Student createStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Student findStudentById(int id);
	
	public Student findStudentByName(String studentName);
	
	public Student findStudentByDate(String date);
	
	public void deleteStudentById(int id);
	
	public void deleteAllStudents();
	
	public Student updateStudentById(int id, Student student);
	
	public Student updateStudentByName(String studentName,Student student);

}
