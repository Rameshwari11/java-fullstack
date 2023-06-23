package com.cgi.dao;

import java.util.List;

import com.cgi.model.Student;

public interface StudentDao {
	
	public List<Student> getAllStudent();

	public Student createStudent(Student student);
	public void getStudentById(int studentId);

	public void deleteStudentById(int studentId);

	public void deleteAllStudents();

	public Student updateStudent(int studentId, Student student);
}
