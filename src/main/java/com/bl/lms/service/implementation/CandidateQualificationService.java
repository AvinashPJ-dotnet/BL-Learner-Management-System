package com.bl.lms.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.QualificationDetailsDTO;
import com.bl.lms.model.CandidateQualification;
import com.bl.lms.repository.CandidateQualificationRepository;
import com.bl.lms.service.interfaces.ICandidateQualificationService;

@Service
public class CandidateQualificationService implements ICandidateQualificationService{

	@Autowired
	CandidateQualificationRepository qualificationRepo;
	
	@Autowired
	ModelMapper mapper;
//	@Override
//	public APIResponse addQualification(String candidate_id, QualificationDetailsDTO qualificationDetails) {
//		// TODO Auto-generated method stub
////		CandidateQualification qualification = mapper.map(qualificationDetails, CandidateQualification.class);
////		qualification.setCandidateId(candidate_id);
////		qualificationRepo.save(qualification);
////		return null;
//	}

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

	@Override
	public APIResponse addQualification(String candidate_id, QualificationDetailsDTO qualificationDetails) {
		// TODO Auto-generated method stub
		return null;
	}

}
