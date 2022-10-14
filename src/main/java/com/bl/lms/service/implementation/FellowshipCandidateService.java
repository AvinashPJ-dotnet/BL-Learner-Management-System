package com.bl.lms.service.implementation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.model.FellowshipCandidate;
import com.bl.lms.model.HiringCandidate;
import com.bl.lms.repository.FellowshipCandidateRepository;
import com.bl.lms.service.interfaces.IFellowshipCandidateService;

@Service
public class FellowshipCandidateService implements IFellowshipCandidateService {

	@Autowired
	FellowshipCandidateRepository fellowshipCandidateRepo;

	ModelMapper mapper = new ModelMapper();

	@Override
	public APIResponse addFellowshipCandidate(HiringCandidate hiringCandidate) {
		// TODO Auto-generated method stub
		FellowshipCandidate newFellowshipCandidate = this.mapper.map(hiringCandidate, FellowshipCandidate.class);
		newFellowshipCandidate.setCic_id(this.generateCICId());
		fellowshipCandidateRepo.save(newFellowshipCandidate);
		return new APIResponse(200, "added successful", fellowshipCandidateRepo.save(newFellowshipCandidate));
	}

	private String generateCICId() {
		// cicid = CIC0012121-112320
		//get last digits from CIC id= newCICid.split("-")[1]
		//get month from CIC id = newCICid.split("CIC")[1].split("-")[0].substring(0,2)
		//get year from CIC id= newCICid.split("CIC")[1].split("-")[0].substring(2)
		String newCICid="";
		LocalDate todayDate = LocalDate.now();
		String proviousCICId = fellowshipCandidateRepo.findTopByOrderByIdDesc().getCic_id();
		if (proviousCICId.isEmpty() | proviousCICId == null) {
			newCICid="CIC"+""+todayDate.getMonthValue()+""+todayDate.getYear()+"-1";
		}
		else {
			if(!proviousCICId.split("CIC")[1].split("-")[0].substring(0,2).equals(String.valueOf(todayDate.getMonthValue()))) {	
				newCICid="CIC"+""+todayDate.getMonthValue()+""+proviousCICId.split("CIC")[1].split("-")[0].substring(2)+"-"+String.valueOf(Integer.parseInt(proviousCICId.split("-")[1])+1);
				if(!proviousCICId.split("CIC")[1].split("-")[0].substring(2).equals(String.valueOf(todayDate.getYear()))) {
					newCICid="CIC"+""+todayDate.getMonthValue()+""+todayDate.getYear()+"-"+String.valueOf(Integer.parseInt(proviousCICId.split("-")[1])+1);
				}
			}
			else if(!proviousCICId.split("CIC")[1].split("-")[0].substring(2).equals(String.valueOf(todayDate.getYear()))) {
				newCICid="CIC"+""+todayDate.getMonthValue()+""+todayDate.getYear()+"-"+String.valueOf(Integer.parseInt(proviousCICId.split("-")[1])+1);
			}
			else {
				newCICid="CIC"+""+proviousCICId.split("CIC")[1].split("-")[0].substring(0,2)+""+proviousCICId.split("CIC")[1].split("-")[0].substring(2)+"-"+String.valueOf(Integer.parseInt(proviousCICId.split("-")[1])+1);
			}
		}
		return newCICid;
	}

	@Override
	public APIResponse getCandidateByStatus(String status) {
		return new APIResponse(200, "successful", fellowshipCandidateRepo.findByCandidateStatus(status));
	}

}
