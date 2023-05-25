package com.cgi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cgi.dao.StudentDao;
import com.cgi.model.Student;

@Component("studentService")
public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;

	@Autowired
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public Student createStudent(Student student) {
		return studentDao.createStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public Student findStudentById(int id) {
		return studentDao.findStudentById(id);
	}

	@Override
	public Student findStudentByName(String studentName) {
		return studentDao.findStudentByName(studentName);
	}

	@Override
	public Student findStudentByDate(String date) {
		return studentDao.findStudentByDate(date);
	}

	@Override
	public void deleteStudentById(int id) {
		studentDao.deleteStudentById(id);

	}

	@Override
	public void deleteAllStudents() {
		studentDao.deleteAllStudents();
	}

	@Override
	public Student updateStudentById(int id, Student student) {
		return studentDao.updateStudentById(id, student);
	}

	@Override
	public Student updateStudentByName(String studentName, Student student) {
		return studentDao.updateStudentByName(studentName, student);
	}

}
