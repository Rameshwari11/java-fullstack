package com.cgi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="associates")
public class Associate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="associate_Id")
	private String associateId;
	
	@Column(name="associate_name")
	private String associateName;
	
	@Column(name="email_Id")
	private String emailId;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="skill_id")
	private int skillId;
	
	@Column(name="skill_name")
	private String skillName;
	
	

}
