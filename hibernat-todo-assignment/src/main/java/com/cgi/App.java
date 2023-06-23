package com.cgi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cgi.model.ToDo;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(ToDo.class).buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		
		ToDo t1 = new ToDo(101,"Daily Exercise", true);
		ToDo t2 = new ToDo(102,"Practice Coding", true);
		ToDo t3 = new ToDo(103,"Practice Yoga", false);
		session.save(t1);
		session.save(t2);
		session.save(t3);

		System.out.println("Todo created successfully...");
		Query query = session.createQuery("FROM ToDo");
		List<ToDo> toDoList = query.getResultList();
		for (ToDo value : toDoList) {
			System.out.println(value);
		}

		System.out.print("Enter ToDo ID: ");

		int id = scanner.nextInt();

		ToDo todo = session.find(ToDo.class, id);

		if (todo == null) {
			System.out.println("no todo activity found..");
		} else {
			System.out.println("Activity Found: " + todo);
		}

		session.getTransaction().commit();
	}
}
