package com.cgi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgi.dao.CustomerDao;
import com.cgi.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Optional<Customer>  getCustomerById(int id) {
		Optional<Customer> customer = customerDao.findById(id);
		return customer;
	}

	@Override
	public void deleteCustomerById(int id) {
		customerDao.deleteById(id);
		
	}

	/*@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}

	@Override
	public void deleteCustomerById(int id) {
		customerDao.deleteCustomerById(id);
		
	}*/

}
