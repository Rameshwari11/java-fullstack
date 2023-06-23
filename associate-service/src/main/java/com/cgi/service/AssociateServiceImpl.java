package com.cgi.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.dto.AssociateDto;
import com.cgi.entity.Associate;
import com.cgi.repository.AssociateRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class AssociateServiceImpl implements AssociateService {
	
	@Autowired
	private AssociateRepository associateRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AssociateDto findByAssociateId(String associateId) {
		Associate associate = associateRepo.findByAssociateId(associateId);	
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AssociateDto associateDto = modelMapper.map(associate, AssociateDto.class);
		return associateDto;
	}

	@Override
	public AssociateDto findByAssociateName(String associateName) {
		Associate associate = associateRepo.findByAssociateName(associateName);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AssociateDto associateDto = modelMapper.map(associate, AssociateDto.class);
		return associateDto;
	}

	@Override
	public AssociateDto findByEmailId(String emailId) {
		Associate associate = associateRepo.findByEmailId(emailId);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AssociateDto associateDto = modelMapper.map(associate, AssociateDto.class);
		return associateDto;
	}

	@Override
	public AssociateDto findByMobileNumber(String mobileNumber) {
		Associate associate = associateRepo.findByMobileNumber(mobileNumber);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AssociateDto associateDto = modelMapper.map(associate, AssociateDto.class);
		return associateDto;
	}

	@Override
	public AssociateDto createAssociate(AssociateDto requestModel) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Associate associate = modelMapper.map(requestModel, Associate.class); 
		return modelMapper.map(associateRepo.save(associate), AssociateDto.class);
	}

	@Override
	public AssociateDto findBySkillName(String skillName) {
		Associate associate = associateRepo.findBySkillName(skillName);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AssociateDto associateDto = modelMapper.map(associate, AssociateDto.class);
		return associateDto;
	}

	
	

}
