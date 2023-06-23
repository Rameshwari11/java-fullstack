package com.cgi.service;

import com.cgi.dto.AssociateDto;
import com.cgi.entity.Associate;

public interface AssociateService {
	
	public AssociateDto createAssociate(AssociateDto requestBody);
	
	public AssociateDto findByAssociateId(String associateId);

	public AssociateDto findByAssociateName(String associateName);

	public AssociateDto findByEmailId(String emailId);

	public AssociateDto findByMobileNumber(String mobileNumber);
	
	public AssociateDto findBySkillName(String skillName);
       


}
