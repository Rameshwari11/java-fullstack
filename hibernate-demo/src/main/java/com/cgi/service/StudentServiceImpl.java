package com.cgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cgi.dao.StudentDao;
import com.cgi.dao.StudentDaoImpl;
import com.cgi.model.Student;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	{
		studentDao = new StudentDaoImpl();
	}

	@Override
	public Student createStudent(Student student) {
		return studentDao.createStudent(student);
	}

	@Override
	public void deleteStudentById(int studentId) {
		studentDao.deleteStudentById(studentId);

	}

	@Override
	public void deleteAllStudents() {
		studentDao.deleteAllStudents();
		System.out.println("deleted all item");

	}

	@Override
	public Student updateStudent(int studentId, Student student) {
		return studentDao.updateStudent(studentId, student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudent();
	}

	@Override
	public void getStudentById(int studentId) {
		studentDao.getStudentById(studentId);
		
	}

}
