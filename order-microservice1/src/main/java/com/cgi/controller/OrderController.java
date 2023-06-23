

package com.cgi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class OrderController {

	private Environment environment;
	
	public OrderController(Environment environment) {
		super();
		this.environment = environment;
	}
	
	@GetMapping()
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("order-service is up and running on port: "+environment.getProperty("local.server.port"));
	}


	

}
