package com.cgi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cgi.dto.AssociateDto;
import com.cgi.exception.MyCustomException;
import com.cgi.model.ErrorModel;
import com.cgi.model.Skill;
import com.cgi.service.AssociateServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/associate")
@AllArgsConstructor
@ControllerAdvice
public class AssociateController {
	
	@Autowired
	private  AssociateServiceImpl associateService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@ExceptionHandler({MyCustomException.class ,  HttpClientErrorException.class, })	
	public ResponseEntity<ErrorModel> handleException(Exception e)
	{
		ErrorModel error=new ErrorModel(HttpStatus.NOT_FOUND.value(),"Skill Mapping Not Found",System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(value = IllegalArgumentException.class )	
	public ResponseEntity<ErrorModel> otherException(Exception e)
	{
		ErrorModel error=new ErrorModel(HttpStatus.CONFLICT.value(),"Give valid search value ",System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	
	@PostMapping("/createAssociate")
	private ResponseEntity<?> createAssociate(@RequestBody AssociateDto requestModel) throws HttpClientErrorException
	{
		Skill skill = restTemplate.getForObject("http://host.docker.internal:8083/skill-microservice/skill/findById/{Id}",Skill.class, Map.of("Id",requestModel.getSkillId()));
		if(skill !=null) {
		requestModel.setSkillId(skill.getId());
		requestModel.setSkillName(skill.getSkillName());
		AssociateDto result = associateService.createAssociate(requestModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(result)	;
		}
		else throw new MyCustomException();	
	}
	
	@GetMapping("/findByAssociateId/{id}")
	public ResponseEntity<?> getAssociateById(@PathVariable String id) throws IllegalArgumentException
	{
		 
		AssociateDto result = associateService.findByAssociateId(id);
		return  ResponseEntity.status(HttpStatus.OK).body(result);		
	}
	
	@GetMapping("/findByAssociateName/{name}")
	public ResponseEntity<?> getAssociateByName(@PathVariable String name) throws IllegalArgumentException
	{ 
		AssociateDto result = associateService.findByAssociateName(name);
		return  ResponseEntity.status(HttpStatus.OK).body(result);	
	}
	
	@GetMapping("/findByAssociateEmailId/{emailId}")
	public ResponseEntity<?> getAssociateByEmailId(@PathVariable String emailId) throws IllegalArgumentException
	{
		AssociateDto result = associateService.findByEmailId(emailId);
		return  ResponseEntity.status(HttpStatus.OK).body(result);		
	}
	
	
	@GetMapping("/findByAssociateMobileNumber/{mobileNumber}")
	public ResponseEntity<?> getAssociateByMobileNumber(@PathVariable String mobileNumber) throws IllegalArgumentException
	{
		AssociateDto result = associateService.findByMobileNumber(mobileNumber);
		return  ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@GetMapping("/findBySkill/{skill}")
	public ResponseEntity<?> getAssociateBySkill(@PathVariable String skill) throws IllegalArgumentException
	{
		AssociateDto result = associateService.findBySkillName(skill);
		return  ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	

}
