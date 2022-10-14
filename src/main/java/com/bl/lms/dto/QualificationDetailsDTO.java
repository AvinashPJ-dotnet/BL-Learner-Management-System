package com.bl.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualificationDetailsDTO {
	private boolean diploma;
	private String degree_name;
	private boolean is_degree_name_verified; 
	private String employee_decipline;
	private boolean is_employee_decipline_verified;
	private int passing_year;
	private boolean is_passing_year_verified;
	private float aggr_per;
	private String final_year_per;
	private boolean is_final_year_per_verified;
	private String training_institute;
	private boolean is_training_institute_verified;
	private String training_duration_month;
	private boolean is_training_duration_month_verified;
	private String other_training;
	private boolean is_other_training_verified;
}
