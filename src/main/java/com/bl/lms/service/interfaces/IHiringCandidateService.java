package com.bl.lms.service.interfaces;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.HiringCandidateDTO;

public interface IHiringCandidateService {

	public APIResponse addHiringCandidate(String token, HiringCandidateDTO hiringCandidateDTO);
	
}
