package com.cgi.service;

import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

import com.cgi.model.Person;
import com.cgi.repo.PersonRepository;


@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;
	
	
	public PersonServiceImpl(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}
	
	@Override
	public Person createPerson(Person person) {
		// TODO Auto-generated method stub
		return  personRepository.createPerson(person);
	}

	@Override
	public Collection<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personRepository.getAllPersons();
	}

	@Override
	public Person getPersonByIdPerson(Integer personId) {
		// TODO Auto-generated method stub
		
		return personRepository.getPersonByIdPerson(personId);
		
	}

	@Override
	public Person updatePersonById(Integer personId, Person person) {
		// TODO Auto-generated method stub
		return personRepository.updatePersonById(personId, person);
	}

	@Override
	public void deletePerson(Integer personId) {
		personRepository.deletePerson(personId);
		
	}

	@Override
	public Person findPersonByName(String personName) {
		// TODO Auto-generated method stub
		return personRepository.findPersonByName(personName);
	}

	@Override
	public Person findPersonByLastName(String lastName) {
		// TODO Auto-generated method stub
		return personRepository.findPersonByLastName(lastName);
	}

	@Override
	public Person findPersonByEmail(String email) {
		// TODO Auto-generated method stub
		return personRepository.findPersonByEmail(email);
	}

	@Override
	public Person updateByLastName(String lastName, Person person) {
		// TODO Auto-generated method stub
		return personRepository.updateByLastName(lastName, person);
	}

	@Override
	public Person updateByEmail(String email, Person person) {
		// TODO Auto-generated method stub
		return personRepository.updateByEmail(email, person);
	}

	

}