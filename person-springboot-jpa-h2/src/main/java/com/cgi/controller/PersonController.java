package com.cgi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.model.Person;
import com.cgi.service.PersonServiceImpl;

@RestController
public class PersonController {
	
	
	@Autowired
	private PersonServiceImpl personServiceImpl;
	
	@PostMapping("/create/person")
	public ResponseEntity<Person> createPerson(@RequestBody Person person)
	{
		Person p= personServiceImpl.createPerson(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
		
	}
	
	@GetMapping("/getAll/person")
	public ResponseEntity<List<Person>> getAllPersons()
	{
		List<Person> p= personServiceImpl.getAllPersonList();
		return ResponseEntity.status(HttpStatus.OK).body(p);
		
	}
	

}
