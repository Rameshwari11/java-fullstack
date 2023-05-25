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
	public Student createStudent(Student student) {
		Session session = getSession();
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		Query query = getSession().createQuery("FROM Student");
		List<Student> studentsList = query.getResultList();
		return studentsList;
	}

	@Override
	public Student findStudentById(int studentId) {
		Student student = getSession().find(Student.class, studentId);
		System.out.println("Student Found with StudentId " + studentId + " Detail " + student );
		return student;
	}

	@Override
	public Student findStudentByName(String studentName) {
		
		Query query = getSession().createQuery("SELECT s FROM Student s where name='"+studentName+"'");
		Student student = (Student) query.getSingleResult();
		System.out.println("Student Found with Name " + studentName + " Detail "+ student);
		return student;
	}
	

	@Override
	public Student findStudentByDate(String date) {
		Query query = getSession().createQuery("SELECT s FROM Student s where entering_date='"+date+"'");
		Student student = (Student) query.getSingleResult();
		System.out.println("Student Found with Date" + date + " Detail "+ student);
		return student;
	}

	@Override
	public void deleteStudentById(int studentId) {
		Session session = getSession();
		session.getTransaction().begin();
		Student result = session.get(Student.class, studentId);
		if (result == null) {
			System.out.println("Matching Student Id Not Found  " + studentId );
		} else {
			session.delete(result);
			System.out.println("Given Student ID " + studentId + " has been removed ");
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

	@Override
	public Student updateStudentById(int id, Student student) {
		Session session = getSession();
		session.getTransaction().begin();
		Student updateStudent = session.get(Student.class, id);
		if (updateStudent == null) {
			System.out.println("Matching Student Id Not Found  " + id);
		} else {
			updateStudent.setName(student.getName());
			updateStudent.setCode(student.getCode());
			updateStudent.setNationality(student.getNationality());
			updateStudent.setEnteringDate(student.getEnteringDate());
			System.out.println("Updated Student Details for Student ID " +id + " Updated Value " + updateStudent);
		}
		session.getTransaction().commit();
		return updateStudent;
	}

	@Override
	public Student updateStudentByName(String studentName, Student student) {
		Session session = getSession();
		session.getTransaction().begin();
		Query query = getSession().createQuery("SELECT s FROM Student s where name='"+studentName+"'");
		Student resultStudent = (Student) query.getSingleResult();
		if (resultStudent == null) {
			System.out.println("Matching Student Name Not Found  " + studentName + " Try with valid name ");
		} else {
			resultStudent.setCode(student.getCode());
			resultStudent.setNationality(student.getNationality());
			resultStudent.setEnteringDate(student.getEnteringDate());
			System.out.println("Updated Student Details for Student Name " + studentName + " Updated Value " + resultStudent);
		}
		session.getTransaction().commit();
		return resultStudent;
	}
	
}