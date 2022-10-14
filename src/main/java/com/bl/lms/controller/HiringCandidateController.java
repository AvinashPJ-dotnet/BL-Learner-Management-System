package com.bl.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.HiringCandidateDTO;
import com.bl.lms.service.interfaces.IHiringCandidateService;

@RestController
@RequestMapping("/hiring")
public class HiringCandidateController {
	
	@Autowired
	IHiringCandidateService hiringCandidateService;
	
	@PostMapping("/candidate")
    public APIResponse addHiringCandidate(@RequestHeader String token,@RequestBody HiringCandidateDTO hiringCandidateDTO) {
    	return hiringCandidateService.addHiringCandidate(token, hiringCandidateDTO);
    }
	
}
