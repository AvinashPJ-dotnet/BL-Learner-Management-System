package com.bl.lms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.CandidateBankDetailsDTO;
import com.bl.lms.dto.QualificationDetailsDTO;
import com.bl.lms.service.interfaces.IFellowshipCandidateService;

@RestController
@RequestMapping("/onboarding/")
public class OnboardController {
	IFellowshipCandidateService fellowshipService;

	@GetMapping("/candidates/status/{status}")
	public APIResponse getAllCandidatesByStatus(@PathVariable("status") String status) {
		return fellowshipService.getCandidateByStatus(status);

	}

	// add candidate bank details
	@PostMapping("/candidates/bank/{candidate_id}")
	public APIResponse addBankDetails(@PathVariable("candidate_id") String candidate_id,@RequestBody CandidateBankDetailsDTO bankDetails) {
		return null;
	}

	@PatchMapping("/candidates/bank/{candidate_id}")
	public APIResponse updateBankDetails(@PathVariable("candidate_id") String candidate_id, @RequestBody CandidateBankDetailsDTO bankDetails) {
		return null;
	}

	// add candidate bank details
	@PostMapping("/candidates/qualification/{candidate_id}")
	public APIResponse addQualificationDetails(@PathVariable("candidate_id") String candidate_id,@RequestBody QualificationDetailsDTO qualificationDetails) {
		return null;
	}

	@PatchMapping("/candidates/bank/{candidate_id}")
	public APIResponse updateQualificationDetails(@PathVariable("candidate_id") String candidate_id,@RequestBody QualificationDetailsDTO qualificationDetails) {
		return null;
	}

}
