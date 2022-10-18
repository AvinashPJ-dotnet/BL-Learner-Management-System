package com.bl.lms.service.implementation;

import org.springframework.stereotype.Service;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.QualificationDetailsDTO;
import com.bl.lms.service.interfaces.ICandidateQualificationService;

@Service
public class CandidateQualificationService implements ICandidateQualificationService{

	@Override
	public APIResponse addQualification(String candidate_id, QualificationDetailsDTO qualificationDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public APIResponse updateQualification(String candidate_id, QualificationDetailsDTO qualificationDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public APIResponse getQualification(String candidate_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
