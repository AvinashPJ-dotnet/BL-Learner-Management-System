package com.bl.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.CandidateBankDetailsDTO;
import com.bl.lms.dto.QualificationDetailsDTO;
import com.bl.lms.service.interfaces.ICandidateBankDetailsService;
import com.bl.lms.service.interfaces.ICandidateQualificationService;
import com.bl.lms.service.interfaces.IFellowshipCandidateService;

@RestController
@RequestMapping("/onboarding")
public class OnboardController {
	@Autowired
	IFellowshipCandidateService fellowshipService;
	@Autowired
	ICandidateBankDetailsService bankService;
	@Autowired
	ICandidateQualificationService qualificationService;

	@GetMapping("/candidates/status/{status}")
	public APIResponse getAllCandidatesByStatus(@PathVariable("status") String status) {
		return fellowshipService.getCandidateByStatus(status);

	}

	// add candidate bank details
	@PostMapping("/candidates/bank/{candidate_id}")
	public APIResponse addBankDetails(@PathVariable("candidate_id") String candidate_id,@RequestBody CandidateBankDetailsDTO bankDetails) {
		bankService.addBankDetails(candidate_id,bankDetails);
		return null;
	}
	
	@GetMapping("/candidates/bank/{candidate_id}")
	public APIResponse fetchBankDetails(@PathVariable("candidate_id") String candidate_id) {
		bankService.getBankDetails(candidate_id);
		return null;
	}

	@PutMapping("/candidates/bank/{candidate_id}")
	public APIResponse updateBankDetails(@PathVariable("candidate_id") String candidate_id, @RequestBody CandidateBankDetailsDTO bankDetails) {
		bankService.updateBankDetails(candidate_id,bankDetails);
		return null;
	}

	// add candidate qualification details
	@PostMapping("/candidates/qualification/{candidate_id}")
	public APIResponse addQualificationDetails(@PathVariable("candidate_id") String candidate_id,@RequestBody QualificationDetailsDTO qualificationDetails) {
		qualificationService.addQualification(candidate_id,qualificationDetails);
		return null;
		
	}
	
	@GetMapping("/candidates/qualification/{candidate_id}")
	public APIResponse fetchQualificationDetails(@PathVariable("candidate_id") String candidate_id) {
		qualificationService.getQualification(candidate_id);
		return null;
		
	}


	@PatchMapping("/candidates/qualification/{candidate_id}")
	public APIResponse updateQualificationDetails(@PathVariable("candidate_id") String candidate_id,@RequestBody QualificationDetailsDTO qualificationDetails) {
		qualificationService.updateQualification(candidate_id,qualificationDetails);
		return null;
	}

}
