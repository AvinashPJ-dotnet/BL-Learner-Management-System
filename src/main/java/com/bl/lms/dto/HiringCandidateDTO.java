package com.bl.lms.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HiringCandidateDTO {

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
	private String joinDate;
	private double aggregatePercentage;
	private int currentPincode;
	private int permanentPincode;
	
	 
	
	
	
}
