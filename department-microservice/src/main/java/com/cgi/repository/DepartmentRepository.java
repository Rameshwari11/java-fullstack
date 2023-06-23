package com.cgi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{

}
