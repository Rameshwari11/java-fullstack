package com.cgi.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cgi.model.Person;

@Service
public class PersonRepositoryImpl implements PersonRepository {

	private Map<Integer, Person> persons = null;

	{
		persons = new HashMap<Integer, Person>();
	}

	@Override
	public Person createPerson(Person person) {
		// TODO Auto-generated method stub
		persons.put(person.getPersonId(), person);
		return person;
	}

	@Override
	public Collection<Person> getAllPersons() {
		// TODO Auto-generated method stub
		System.out.println(persons);
		return persons.values();
	}

	@Override
	public Person getPersonByIdPerson(Integer personId) {
		// TODO Auto-generated method stub
		Person thePerson = persons.get(personId);

		System.out.println(thePerson);
		if (thePerson == null) {
			return null;
		} else
			return thePerson;

	}

	@Override
	public Person updatePersonById(Integer personId, Person person) {

		Person thePerson = persons.get(personId);

		if (thePerson != null) {
			thePerson.setPersonId(person.getPersonId());
			thePerson.setFirstName(person.getFirstName());
			thePerson.setLastName(person.getLastName());
			thePerson.setEmail(person.getEmail());
		}

		return thePerson;

	}

	@Override
	public void deletePerson(Integer personId) {
		try {
			persons.remove(personId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Person findPersonByName(String personName) {
		Person p = null;
		Collection<Person> result = persons.values();

		for (Person r : result) {
			if (r.getFirstName().equalsIgnoreCase(personName)) {
				return r;
			}
		}
		return p;

	}

	@Override
	public Person findPersonByLastName(String lastName) {
		Person p = null;
		Collection<Person> result = persons.values();

		for (Person r : result) {
			if (r.getLastName().equalsIgnoreCase(lastName)) {
				return r;
			}
		}
		return p;

	}

	@Override
	public Person findPersonByEmail(String email) {
		Person p = null;
		Collection<Person> result = persons.values();

		for (Person r : result) {
			if (r.getEmail().equalsIgnoreCase(email)) {
				return r;
			}
		}
		return p;

	}
	
	@Override
	public Person updateByLastName(String lastName,Person person) {
		
		Person p = findPersonByLastName(lastName);
		
		if(p!=null )
		{
			p.setFirstName(person.getFirstName());
			p.setEmail(person.getEmail());
			p.setPersonId(person.getPersonId());
			p.setLastName(person.getLastName());
		}
		return p;
	}

	@Override
	public Person updateByEmail(String email, Person person) {
		Person p = findPersonByEmail(email);
		if(p!=null )
		{
			p.setFirstName(person.getFirstName());
			p.setEmail(person.getEmail());
			p.setPersonId(person.getPersonId());
			p.setLastName(person.getLastName());
		}
		return p;
	}

	
	
	

}