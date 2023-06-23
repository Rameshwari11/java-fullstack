package com.cgi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.model.Skill;
import com.cgi.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepo;
	
	
	public Skill createSkill(Skill requestBody)
	{
		Skill skill = skillRepo.save(requestBody);
		return skill;
	}
	
	public List<Skill> getAll(){
		List<Skill> result = skillRepo.findAll();
		return result;
	}
	
	public Optional<Skill> getSkillById(int  id)
	{
		Optional<Skill> skill = skillRepo.findById(id);
		return skill;
	}

	
}
