package com.bl.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualificationDetailsDTO {
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
}
