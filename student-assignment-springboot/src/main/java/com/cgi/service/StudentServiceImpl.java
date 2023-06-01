package com.cgi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.cgi.dao.StudentDao;
import com.cgi.model.Student;

@Service
public class StudentServiceImpl implements StudentService {


	private final  StudentDao studentdao;
	
	public StudentServiceImpl(StudentDao studentdao) {
		super();
		this.studentdao = studentdao;
	}

	@Override
	public Student createStudent(Student student) {
		return studentdao.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentdao.findAll();
	}

	@Override
	public Optional<Student> findStudentById(int id) {
		return studentdao.findById(id);
	}

	@Override
	public List<Student> findByName(String name) {
		List<Student> student = studentdao.findByName(name);
		return student;
	}

	
	@Override
	public void deleteStudentById(int id) {
		studentdao.deleteById(id);
		
	}

	@Override
	public void deleteAllStudent() {
		studentdao.deleteAll();
	}
	

}
