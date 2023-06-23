package com.cgi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.cgi.model.Customer;


/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner scanner=new Scanner(System.in);
    public static void main( String[] args )
    {
    SessionFactory factory=new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
    Session session=factory.openSession();
    session.getTransaction().begin();
    /*Customer c1 = new Customer(200, "Rohit", "Sharma", "rs@email.com") ;
    Customer c2 = new Customer(201, "Virat", "Kohli", "vk@email.com") ;
    Customer c3 = new Customer(202, "Sachin", "Tendulkar", "st@email.com") ;
    Customer c4 = new Customer(203, "Rahul", "Dravid", "rd@email.com") ;
    session.save(c3);
    session.save(c4);
    session.save(c2);
    session.save(c1);
    System.out.println("customer created...");
    Query query=session.createQuery("FROM Customer");
    List<Customer> customers= query.getResultList();
    for(Customer c:customers)
    {
    	System.out.println(c);
    }*/
    
    System.out.print("Enter Customer ID: ");
    
    int id=scanner.nextInt();
    
    Customer customer=session.find(Customer.class, id);
    
    if(customer==null)
    {
    	System.out.println("no such customer found..");
    }
    else
    {
    	System.out.println("Found: "+customer);
    }
    
    session.getTransaction().commit();
    }
}
