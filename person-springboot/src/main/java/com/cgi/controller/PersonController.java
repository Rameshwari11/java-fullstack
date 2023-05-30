package com.cgi.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.model.Person;
import com.cgi.service.PersonService;

@RestController
public class PersonController {

	private PersonService personService;

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@PostMapping("/persons")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {

		Person p = personService.createPerson(person);

		return ResponseEntity.status(HttpStatus.CREATED).body(p);

	}

	@GetMapping("/persons")
	public ResponseEntity<Collection<Person>> getAllPersons() {
		return ResponseEntity.ok().body(personService.getAllPersons());
	}

	@GetMapping("/persons/{personId}")
	public ResponseEntity<?> getPersonById(@PathVariable("personId") Integer personid) {
		Person p = personService.getPersonByIdPerson(personid);
		System.out.println(p);

		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with id: " + personid + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}

	
	@PutMapping("/persons/{personId}")
	public ResponseEntity<?> updatePersonById(@PathVariable("personId") Integer personid, @RequestBody Person person) {
		Person p = personService.updatePersonById(personid, person);
		System.out.println(p);

		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with id: " + personid + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}
	
	

	@DeleteMapping("/persons/{personId}")
	public ResponseEntity<Object> deletePerson(@PathVariable("personId") Integer personId) {
		personService.deletePerson(personId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/persons/v1/{personName}")
	public ResponseEntity<Object> updatePersonByName(@PathVariable("personName") String personName) {
		Person p = personService.findPersonByName(personName);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with name : " + personName + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}
	
	@GetMapping("/persons/v2/{lastName}")
	public ResponseEntity<Object> updatePersonByLastName(@PathVariable("lastName") String lastName) {
		Person p = personService.findPersonByLastName(lastName);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with name : " + lastName + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}
	
	@GetMapping("/persons/v3/{email}")
	public ResponseEntity<Object> updatePersonByEmail(@PathVariable("email") String email) {
		Person p = personService.findPersonByEmail(email);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with email : " + email + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}
	@PutMapping("/persons/v5/{lastName}")
	public ResponseEntity<?> updatePersonByLastName(@PathVariable("lastName") String lastName, @RequestBody Person person) {
		Person p = personService.updateByLastName(lastName, person);
		System.out.println(p);

		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with lastName: " + lastName + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}
	@PutMapping("/persons/v6/{email}")
	public ResponseEntity<?> updatePersonByEmail(@PathVariable("email") String email, @RequestBody Person person) {
		Person p = personService.updateByEmail(email, person);
		System.out.println(p);

		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with email: " + email + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}
}
