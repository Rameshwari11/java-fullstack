package com.cgi.service;

import java.util.List;

import com.cgi.model.Student;

public interface StudentService {
	public List<Student> getAllStudent();
	public void getStudentById(int studentId);
	public Student createStudent(Student student);
	public void deleteStudentById(int studentId);
	public void deleteAllStudents();
	public Student updateStudent(int studentId,Student student);

}
