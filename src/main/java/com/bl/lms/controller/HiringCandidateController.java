package com.bl.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.HiringCandidateDTO;
import com.bl.lms.model.HiringCandidate;
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
	
	@PostMapping("/candidates")
    public APIResponse addMultipleHiringCandidates(@RequestHeader String token,@RequestBody List<HiringCandidateDTO> hiringCandidateList) {
    	return hiringCandidateService.addMultipleHiringCandidates(token, hiringCandidateList);
    }
	
	@GetMapping("/candidate/{id}")
	public APIResponse viewCandidateProfile(@RequestHeader String token,@PathVariable long id) {
		return hiringCandidateService.viewCandidateProfile(token,id);
	}
	
	@PutMapping("/candidate/{id}/{status}")
	public APIResponse updateCandidateStatus(@RequestHeader String token,@PathVariable long id,@PathVariable String status) {
		return hiringCandidateService.updateCandidateStatus(token,id,status);
	}
	
	@GetMapping("/candidate/count/{status}")
	public APIResponse getCandidatesCount(@RequestHeader String token, @PathVariable String status) {
		return hiringCandidateService.getCandidatesCount(token,status);
	}
	
	@GetMapping("/candidates/{status}")
	public APIResponse getCandidateList(@RequestHeader String token, @PathVariable String status) {
		return hiringCandidateService.getCandidateList(token,status);
	}
	
	@GetMapping("/candidates")
	public APIResponse getCandidateListByIDs(@RequestHeader String token, @RequestBody List<Long> idList) {
		return hiringCandidateService.getCandidateListByIDs(token,idList);
	}
}

