package com.cgi.service;

import java.util.List;

import com.cgi.model.Person;

public interface PersonService {
	
	public Person createPerson(Person person);
	public  List<Person> getAllPersonList();
	

}
