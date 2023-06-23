package com.cgi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
