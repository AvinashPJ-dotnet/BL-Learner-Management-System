package com.bl.lms.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "Fellowship_Candidate")
public class FellowshipCandidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id ;
	 private String cic_id;
	 private String email ;
	 private String first_name;
	 private String middle_name;
	 private String last_name;
	 private String hired_city;
	 private String degree;
	 private String hired_date;
	 private String hired_lab ;
	 private String mobile_number;
	 private String permanent_pincode;
	 private String attitude;
	 private String communication_remark;
	 private String knowledge_remark;
	 private String aggregate_remark;
	 private Date creator_stamp;
	 private String creator_user;
	 private Date birth_date;
	 private boolean is_birth_verified;
	 private String parent_name;
	 private String parent_occupation;
	 private String parent_mobile_number;
	 private String parent_annual_salary;
	 private String local_addess;
	 private String permanent_addess;
	 private String photo_path;
	 private Date joining_date;
	 private String candidate_status;
}
