package com.bl.lms.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class HiringCandidate {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String mobileNumber;
	private String hiredCity;
	private String hiredDate;
	private String degree;
	private String hiredLab;
	private String attitudeRemark;
	private String communicationRemark;
	private String knowledgeRemark;
//	private String onboardingStatus;
	private String status;  
	private String joinDate;
	private double aggregatePercentage;
	private int currentPincode;
	private int permanentPincode;
	private LocalDateTime creatorStamp;
	private long creatorUser;  
	
}
