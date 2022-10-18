package com.bl.lms.service.interfaces;

import java.util.List;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.HiringCandidateDTO;
import com.bl.lms.model.HiringCandidate;

public interface IHiringCandidateService {

	public APIResponse addHiringCandidate(String token, HiringCandidateDTO hiringCandidateDTO);

	public APIResponse addMultipleHiringCandidates(String token, List<HiringCandidateDTO> hiringCandidateList);
	
	public HiringCandidate convertDtoToEntity(HiringCandidateDTO candidateDTO);

	public APIResponse viewCandidateProfile(String token, long id);

	public APIResponse updateCandidateStatus(String token, long id, String status);

	public APIResponse getCandidatesCount(String token, String status);

	public APIResponse getCandidateList(String token, String status);

	public APIResponse getCandidateListByIDs(String token, List<Long> idList); 
}

