package com.cgi.service;

import java.util.List;
import java.util.Optional;

import com.cgi.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();

	public Customer createCustomer(Customer customer);
	
	public Optional<Customer> getCustomerById(int id);
	
	public void deleteCustomerById(int id);
}
