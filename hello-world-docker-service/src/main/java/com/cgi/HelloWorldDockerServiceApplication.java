package com.cgi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class HelloWorldDockerServiceApplication {
	
	private final Environment environment;

	public HelloWorldDockerServiceApplication(Environment environment) {
		super();
		this.environment = environment;
	}

	

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldDockerServiceApplication.class, args);
	}
	
	@GetMapping
	public ResponseEntity<String> welcome()
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body("Welcome to 1st Docker Project in the port...!!!" );
	}

}
