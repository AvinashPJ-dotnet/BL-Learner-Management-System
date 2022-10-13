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
@Table(name = "Candidate_Bank_Details")
public class CandidateBankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String candidate_id;
	private String name;
	private String account_number;
	private boolean is_account_number_verified;
	private boolean is_ifsc_code_verified;
	private String ifsc_code;
	private boolean is_pan_number_verified;
	private String pan_number;
	private boolean is_addhaar_number_verified;
	private String addhaar_number;
	private Date creator_stamp;
	private String creator_user;
}
