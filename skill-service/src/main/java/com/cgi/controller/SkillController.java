package com.cgi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.model.Skill;
import com.cgi.services.SkillService;


@RestController
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping("/getAll")
	private ResponseEntity<?> getAllSkills()
	{
		List<Skill> result=skillService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@GetMapping("/findById/{Id}")
	private ResponseEntity<?> getSkillById(@PathVariable int Id)
	{
		Optional<Skill> result=skillService.getSkillById(Id);
		if(result.isPresent()) {
		return ResponseEntity.status(HttpStatus.OK).body(result);
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
/*	@PostMapping("/findBySkillName")
	private ResponseEntity<?> getSkillById(@RequestBody List<String> skillName)
	{
		Optional<List<Skill>> result=skillService.getSkillBySkillName(skillName);
		if(result.isPresent()) {
		return ResponseEntity.status(HttpStatus.OK).body(result);
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}*/
	
	@PostMapping("/create")
	private ResponseEntity<?> createSkill(@RequestBody Skill skill)
	{
		Skill result = skillService.createSkill(skill);
		return ResponseEntity.status(HttpStatus.CREATED).body(result)	;
	}
	
	
	

}
