package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.model.Customer;

@Repository
@EnableTransactionManagement
public class CustomerDaoImpl  {

	// using entityManager insist of sessionFactory
/*
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Customer> getAllCustomers(){
		Query query = (Query) entityManager.createQuery("FROM Customer", Customer.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Customer createCustomer(Customer customer) {
		// save or update
		entityManager.merge(customer);
		return customer;
	}

	@Override
	@Transactional
	public Customer getCustomerById(int theId) {
		Customer customer = entityManager.find(Customer.class, theId);
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomerById(int theId) {
		Customer customer = entityManager.find(Customer.class, theId);
		entityManager.remove(customer);
	}

	/*
	 * private SessionFactory sessionFactory;
	 * 
	 * public CustomerDaoImpl(SessionFactory sessionFactory) { super();
	 * this.sessionFactory = sessionFactory; }
	 * 
	 * @Override
	 * 
	 * @Transactional public List<Customer> getAllCustomers() { Session session =
	 * sessionFactory.openSession(); Query<Customer> query =
	 * session.createQuery("FROM Customer",Customer.class); List<Customer> resultSet
	 * = query.getResultList(); return resultSet; }
	 * 
	 * @Override
	 * 
	 * @Transactional public Customer createCustomer(Customer customer) { Session
	 * session=sessionFactory.openSession(); session.save(customer); return
	 * customer; }
	 * 
	 * @Override
	 * 
	 * @Transactional public Customer getCustomerById(int id) { Session
	 * session=sessionFactory.openSession(); Customer customer =
	 * session.find(Customer.class, id); return customer; }
	 * 
	 * @Override
	 * 
	 * @Transactional public void deleteCustomerById(int id) { Session
	 * session=sessionFactory.openSession(); Customer customer =
	 * session.find(Customer.class, id); session.remove(customer); }
	 */
}

