package com.cgi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.dto.AssociateDto;
import com.cgi.entity.Associate;



public interface AssociateRepository extends JpaRepository<Associate, Integer> {

	public Associate findByAssociateId(String associateId);

	public Associate findByAssociateName(String associateName);

	public Associate findByEmailId(String emailId);

	public Associate findByMobileNumber(String mobileNumber);
	
	public Associate findBySkillName(String skillName);
    
	
}
