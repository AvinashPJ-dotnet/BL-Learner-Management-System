package com.bl.lms.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class FellowshipCandidate {

//	@GeneratedValue(strategy = GenerationType.AUTO)
//	 private long id ;
	@Id
	private String cicId;
	private String emailId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String hiredCity;
	private String degree;
	private String hiredDate;
	private String hiredLab;
	private String mobileNumber;
	private String permanentPincode;
	private String attitudeRemark;
	private String communicationRemark;
	private String knowledgeRemark;
	private String aggregateRemark;
	private Date creatorStamp;
	private String creatorUser;
	private Date birthDate;
	private boolean isBirthVerified;
	private String parentName;
	private String parentOccupation;
	private String parentMobileNumber;
	private String parentAnnualSalary;
	private String localAddess;
	private String permanentAddess;
	private String photoPath;
	private Date joinDate;
	private String candidateStatus;
	private String documentStatus;
//	 private String remark;

//	 private String firstName;
//	 private String middleName;
//	 private String lastName;
//	 private String email;
//	 private String mobileNumber;
//	 private String hiredCity;
//	 private String parentName;
//	 private String parentMobile;
//	 private String temporaryAddress;
//	 private String parentOccupation;
//	 private String parentAnnualSalary;
//	 private String permanentAddress;
//	 private String profileImage;
//	 private String folderId;
//	 private String status;
//	 private String creatorStamp;
//	 private String updateStamp;
//	 private String bankInfo;
//	 private String qualificationInfo;
}
