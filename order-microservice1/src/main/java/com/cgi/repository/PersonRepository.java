package com.cgi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.entity.Person;

public interface PersonRepository extends JpaRepository<Person,Integer>{

}
