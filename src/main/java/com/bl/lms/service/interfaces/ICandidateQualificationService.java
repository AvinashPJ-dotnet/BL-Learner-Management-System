package com.bl.lms.service.interfaces;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.QualificationDetailsDTO;

public interface ICandidateQualificationService {

	APIResponse addQualification(String candidate_id, QualificationDetailsDTO qualificationDetails);

	APIResponse updateQualification(String candidate_id, QualificationDetailsDTO qualificationDetails);

	APIResponse getQualification(String candidate_id);

}
