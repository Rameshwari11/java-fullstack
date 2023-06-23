package com.cgi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class CustomerMicroserviceApplication {
	private Environment environment;

	public CustomerMicroserviceApplication(Environment environment) {
		super();
		this.environment = environment;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerMicroserviceApplication.class, args);
	}
	
	@GetMapping()
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("customer-service is up and running on port: "+environment.getProperty("local.server.port"));
	}

}
