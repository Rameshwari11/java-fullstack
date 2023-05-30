package com.cgi.service;

import java.util.Collection;
import java.util.List;

import com.cgi.model.Person;


public interface PersonService {

	public Person createPerson(Person person);

	public Collection<Person> getAllPersons();
	public Person getPersonByIdPerson(Integer personId);
	public Person updatePersonById(Integer personId , Person person);
	
	public void deletePerson(Integer personId);
	public Person findPersonByName(String personName);
	
	public Person findPersonByLastName(String personName);
	
	public Person findPersonByEmail(String email);	
	public Person updateByLastName(String lastName,Person person);
	public Person updateByEmail(String email,Person person);
	
}