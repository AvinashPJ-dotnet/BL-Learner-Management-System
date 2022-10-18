package com.bl.lms.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class CandidateQualification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private boolean diploma;
	private String degree;
	private boolean isDegreeNameVerified; 
	private String employeeDecipline;
	private boolean isEmployeeDeciplineVerified;
	private int passingYear;
	private boolean isPassingYearVerified;
	private float aggregatePercentage;
	private String finalYearPer;
	private boolean isFinalYearPerVerified;
	private String trainingInstitute;
	private boolean isTrainingInstituteVerified;
	private String trainingDurationMonth;
	private boolean isTrainingDurationMonthVerified;
	private String otherTraining;
	private boolean isOtherTrainingVerified;
	private Date creatorStamp;
	private long creatorUser;
	
	@ManyToOne
	@JoinColumn(name = "candidateId")
	FellowshipCandidate fc; 
	
}
