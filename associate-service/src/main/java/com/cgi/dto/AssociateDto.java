package com.cgi.dto;

import java.util.List;

public class AssociateDto {

	private String associateId;
	private String associateName;
	private String emailId;
	private String mobileNumber;
	private int skillId;
	private String skillName;
	
	
	public int getSkillId() {
		return skillId;
	}
	public AssociateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssociateDto(String associateId, String associateName, String emailId, String mobileNumber, int skillId) {
		super();
		this.associateId = associateId;
		this.associateName = associateName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.skillId = skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getAssociateId() {
		return associateId;
	}
	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}
	public String getAssociateName() {
		return associateName;
	}
	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "AssociateDto [associateId=" + associateId + ", associateName=" + associateName + ", emailId=" + emailId
				+ ", mobileNumber=" + mobileNumber + ", skillId=" + skillId + "]";
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	
}

