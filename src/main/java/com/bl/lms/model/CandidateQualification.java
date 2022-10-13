package com.bl.lms.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Candidate_Qualification")
public class CandidateQualification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String candidate_id;
	private String diploma;
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
	private Date creator_stamp;
	private long creator_user;
	
}
