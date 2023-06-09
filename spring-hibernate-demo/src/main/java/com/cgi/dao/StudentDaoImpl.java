package com.cgi.dao;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.model.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.openSession();
	}


	@Override
	public List<Student> getAllStudents() {
		Query query = getSession().createQuery("FROM Student");
		List<Student> studentsList = query.getResultList();
		return studentsList;
	}

	@Override
	public Student getStudentById(int studentId) {
		Student student = getSession().find(Student.class, studentId);
		return student;
	}

	@Override
	public Student createStudent(Student student) {
		Session session = getSession();
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		return student;
	}

	@Override
	public Student updateStudent(int studentId, Student newStudent) {
		Session session = getSession();
		session.getTransaction().begin();
		Student student = session.get(Student.class, studentId);
		if (student == null) {
			System.out.println("no student found for the id...:" + studentId);
		} else {
			student.setFirstName(newStudent.getFirstName());
			student.setLastName(newStudent.getLastName());
			student.setEmail(newStudent.getEmail());
			session.save(student);
			System.out.println("Student has been updated...");
		}
		session.getTransaction().commit();
		return student;
	}

	@Override
	public void deleteStudentById(int studentId) {
		Session session = getSession();
		session.getTransaction().begin();
		Student student = session.get(Student.class, studentId);
		if (student == null) {
			System.out.println("no student found for the id...:" + studentId);
		} else {
			session.delete(student);
			System.out.println("Student has been deleted...");
		}
		session.getTransaction().commit();
	}

	@Override
	public void deleteAllStudents() {
		Session session = getSession();
		session.getTransaction().begin();

		Query query = session.createQuery("FROM Student");
		List<Student> studentList = query.getResultList();
		for (Student s : studentList) {
			session.delete(s);
		}
		session.getTransaction().commit();
	}
	
	
}