package com.cgi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

}
