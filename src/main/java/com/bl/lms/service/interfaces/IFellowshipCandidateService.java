package com.bl.lms.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.model.FellowshipCandidate;
import com.bl.lms.model.HiringCandidate;


public interface IFellowshipCandidateService {

	public APIResponse addFellowshipCandidate(HiringCandidate hiringCandidate);

	public APIResponse getCandidateByStatus(String status);
}
