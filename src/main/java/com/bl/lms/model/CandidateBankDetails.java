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
public class CandidateBankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String candidateId;
	private String name;
	private String accountNumber;
	private boolean isAccountNumberVerified;
	private boolean isIfscCodeVerified;
	private String ifscCode;
	private boolean isPanNumberVerified;
	private String panNumber;
	private boolean isAddhaarNumberVerified;
	private String addhaarNumber;
	private Date creatorStamp;
	private String creatorUser;
}
