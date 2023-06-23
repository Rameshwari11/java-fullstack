package com.cgi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SkillsTrackerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillsTrackerServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}


}
