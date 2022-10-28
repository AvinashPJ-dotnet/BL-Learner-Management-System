package com.bl.lms.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.model.FellowshipCandidate;
import com.bl.lms.model.HiringCandidate;


public interface IFellowshipCandidateService {

	public APIResponse addFellowshipCandidate(String token,HiringCandidate hiringCandidate);

	public APIResponse getCandidateByStatus(String token,String status);

	public APIResponse updateCandidateStatus(String token, String candidateId, String status);

	public APIResponse countCandidatesByStatus(String token, String status);
}
