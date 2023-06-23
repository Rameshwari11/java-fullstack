package com.cgi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cgi.model.Customer;


public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
