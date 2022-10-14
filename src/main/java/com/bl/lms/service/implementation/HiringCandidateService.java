package com.bl.lms.service.implementation;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.HiringCandidateDTO;
import com.bl.lms.model.HiringCandidate;
import com.bl.lms.repository.HiringCandidateRepository;
import com.bl.lms.repository.UserRepository;
import com.bl.lms.service.interfaces.IHiringCandidateService;
import com.bl.lms.utils.JWTUtil;


@Service
public class HiringCandidateService implements IHiringCandidateService{
	
	@Autowired
	HiringCandidateRepository hiringCandidateRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	JWTUtil jwtUtil;

	@Override
	public APIResponse addHiringCandidate(String token, HiringCandidateDTO hiringCandidateDTO ) {
		HiringCandidate hiringCandidate = 
				modelMapper.map(hiringCandidateDTO, HiringCandidate.class);
		String emailId  =jwtUtil.verify(token);
		hiringCandidate.setOnboardingStatus("Pending");
		hiringCandidate.setCreatorUser(userRepo.findByEmailId(emailId).get().getId());
		hiringCandidate.setCreatorStamp(LocalDateTime.now());
		return new APIResponse(HttpStatus.OK.value(),
				"Hired Candidate details added Successfully",hiringCandidate);
	}
	
}
