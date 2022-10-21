package com.bl.lms.service.implementation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.exception.UserException;
import com.bl.lms.model.CandidateBankDetails;
import com.bl.lms.model.CandidateQualification;
import com.bl.lms.model.FellowshipCandidate;
import com.bl.lms.model.HiringCandidate;
import com.bl.lms.repository.CandidateBankDetailsRepository;
import com.bl.lms.repository.CandidateQualificationRepository;
import com.bl.lms.repository.FellowshipCandidateRepository;
import com.bl.lms.service.interfaces.IFellowshipCandidateService;
import com.bl.lms.utils.JWTUtil;

@Service
public class FellowshipCandidateService implements IFellowshipCandidateService {

	@Autowired
	FellowshipCandidateRepository fellowshipCandidateRepo;

	@Autowired
	CandidateQualificationRepository qualificationRepo;

	CandidateQualification candidateQualification = new CandidateQualification();

	@Autowired
	CandidateBankDetailsRepository bankDetailsRepo;

	CandidateBankDetails bankDetails = new CandidateBankDetails();

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	JWTUtil jwtUtil;

	@Override
	public APIResponse addFellowshipCandidate(String token,HiringCandidate hiringCandidate) {
		jwtUtil.verify(token);
		FellowshipCandidate newFellowshipCandidate = this.mapper.map(hiringCandidate, FellowshipCandidate.class);
		System.out.println("pass1" + newFellowshipCandidate.getDegree());
		newFellowshipCandidate.setCicId(this.generateCICId());
		System.out.println("pass1" + newFellowshipCandidate.getCicId());
		newFellowshipCandidate.setDocumentStatus("pending");
		newFellowshipCandidate.setCandidateStatus("pending");
		newFellowshipCandidate = fellowshipCandidateRepo.save(newFellowshipCandidate);
		System.out.println("pass2");
		this.addCandidateQualification(newFellowshipCandidate);
		System.out.println("pass3");
		this.addCandidatebankDetails(newFellowshipCandidate);
		System.out.println("pass4");
		return new APIResponse(201, "added successful", newFellowshipCandidate);
	}

	private void addCandidateQualification(FellowshipCandidate fellowshipCandidate) {
		
		candidateQualification.setDegree(fellowshipCandidate.getDegree());
		candidateQualification.setFc(fellowshipCandidate);
		qualificationRepo.save(candidateQualification);
	}

	private void addCandidatebankDetails(FellowshipCandidate fellowshipCandidate) {
		bankDetails.setFc(fellowshipCandidate);
		bankDetailsRepo.save(bankDetails);
	}

	private String generateCICId() {
		// cicid = CIC0012121-112320
		// get last digits from CIC id= newCICid.split("-")[1]
		// get month from CIC id = newCICid.split("CIC")[1].split("-")[0].substring(0,2)
		// get year from CIC id= newCICid.split("CIC")[1].split("-")[0].substring(2)
		String newCICid = "";
		String proviousCICId = "";
		LocalDate todayDate = LocalDate.now();
		System.out.println("CIc id bbefore");
		Optional<FellowshipCandidate> fellowshipObject = fellowshipCandidateRepo.findTopByOrderByCicIdDesc();
		System.out.println("CIc id" + fellowshipObject);
		if (!fellowshipObject.isPresent()) {
			newCICid = "CIC" + "" + todayDate.getMonthValue() + "" + todayDate.getYear() + "-1";
		} else {
			proviousCICId = fellowshipObject.get().getCicId();
			if (!proviousCICId.split("CIC")[1].split("-")[0].substring(0, 2)
					.equals(String.valueOf(todayDate.getMonthValue()))) {
				newCICid = "CIC" + "" + todayDate.getMonthValue() + ""
						+ proviousCICId.split("CIC")[1].split("-")[0].substring(2) + "-"
						+ String.valueOf(Integer.parseInt(proviousCICId.split("-")[1]) + 1);
				if (!proviousCICId.split("CIC")[1].split("-")[0].substring(2)
						.equals(String.valueOf(todayDate.getYear()))) {
					newCICid = "CIC" + "" + todayDate.getMonthValue() + "" + todayDate.getYear() + "-"
							+ String.valueOf(Integer.parseInt(proviousCICId.split("-")[1]) + 1);
				}
			} else if (!proviousCICId.split("CIC")[1].split("-")[0].substring(2)
					.equals(String.valueOf(todayDate.getYear()))) {
				newCICid = "CIC" + "" + todayDate.getMonthValue() + "" + todayDate.getYear() + "-"
						+ String.valueOf(Integer.parseInt(proviousCICId.split("-")[1]) + 1);
			} else {
				newCICid = "CIC" + "" + proviousCICId.split("CIC")[1].split("-")[0].substring(0, 2) + ""
						+ proviousCICId.split("CIC")[1].split("-")[0].substring(2) + "-"
						+ String.valueOf(Integer.parseInt(proviousCICId.split("-")[1]) + 1);
			}
		}
		return newCICid;
	}

	@Override
	public APIResponse getCandidateByStatus(String token,String status) {
		return new APIResponse(200, "successful", fellowshipCandidateRepo.findByCandidateStatus(status));
	}

	@Override
	public APIResponse updateCandidateStatus(String token, String candidateId, String status) {
		jwtUtil.verify(token);
		Optional<FellowshipCandidate> candidate=fellowshipCandidateRepo.findById(candidateId);
		if(candidate.isEmpty()) {
			throw new UserException("candidate not found");
		}
		FellowshipCandidate updatedCandidate = candidate.get();
		updatedCandidate.setCandidateStatus(status);
		updatedCandidate = fellowshipCandidateRepo.save(updatedCandidate);
		return new APIResponse(200, "successful", updatedCandidate);
	}

	@Override
	public APIResponse countCandidatesByStatus(String token, String status) {
		jwtUtil.verify(token);
		return new APIResponse(200, "successful", fellowshipCandidateRepo.findByCandidateStatus(status).stream().count());
	}

}
