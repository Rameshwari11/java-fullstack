package com.cgi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cgi.model.Student;

public interface StudentDao extends JpaRepository<Student , Integer> {
	
	@Query
	public List<Student> findByName(String name);

}
