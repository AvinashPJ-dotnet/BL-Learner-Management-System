package com.bl.lms.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.HiringCandidateDTO;
import com.bl.lms.dto.UserDTO;
import com.bl.lms.exception.UserException;
import com.bl.lms.model.HiringCandidate;
import com.bl.lms.model.User;
import com.bl.lms.repository.HiringCandidateRepository;
import com.bl.lms.repository.UserRepository;
import com.bl.lms.service.interfaces.IHiringCandidateService;
import com.bl.lms.utils.EmailSenderService;
import com.bl.lms.utils.JWTUtil;

@Service
public class HiringCandidateService implements IHiringCandidateService {

	@Autowired
	HiringCandidateRepository hiringCandidateRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	FellowshipCandidateService fcService;

	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	EmailSenderService emailSenderService;

	@Override
	public HiringCandidate convertDtoToEntity(HiringCandidateDTO candidateDTO) {

		TypeMap<HiringCandidateDTO, HiringCandidate> typeMap = modelMapper.getTypeMap(HiringCandidateDTO.class,
				HiringCandidate.class);
		if (typeMap == null) { // if not already added
			TypeMap<HiringCandidateDTO, HiringCandidate> propertyMapper = this.modelMapper
					.createTypeMap(HiringCandidateDTO.class, HiringCandidate.class);
			propertyMapper.addMappings(mapper -> mapper.skip(HiringCandidate::setId));
		}

		HiringCandidate candidate = new HiringCandidate();
		candidate = this.modelMapper.map(candidateDTO, HiringCandidate.class);
		return candidate;

	}

	@Override
	public APIResponse addHiringCandidate(String token, HiringCandidateDTO hiringCandidateDTO) {
		String emailId = jwtUtil.verify(token);
		hiringCandidateRepo.findByEmailId(hiringCandidateDTO.getEmailId()).ifPresent(candidate -> {
			throw new UserException("Candidate Already added");
		});
		HiringCandidate hiringCandidate = convertDtoToEntity(hiringCandidateDTO);
		hiringCandidate.setStatus("Pending");
		hiringCandidate.setCreatorUser(userRepo.findByEmailId(emailId).get().getId());
		hiringCandidate.setCreatorStamp(LocalDateTime.now());
		hiringCandidateRepo.save(hiringCandidate);
		fcService.addFellowshipCandidate(hiringCandidate);
		return new APIResponse(HttpStatus.OK.value(), "Hired Candidate details added Successfully", hiringCandidate);
	}

	@Override
	public APIResponse addMultipleHiringCandidates(String token, List<HiringCandidateDTO> hiringCandidateList) {
		String emailId = jwtUtil.verify(token);
		hiringCandidateList.stream().forEach(
				candidate -> hiringCandidateRepo.findByEmailId(candidate.getEmailId()).ifPresent(exCandidate -> {
					throw new UserException("Candidate" + exCandidate.getFirstName() + exCandidate.getMiddleName()
							+ exCandidate.getLastName() + " Already added");
				}));
		List<HiringCandidate> candidates = hiringCandidateList.stream().map(this::convertDtoToEntity)
				.collect(Collectors.toList());
		candidates.stream().forEach(candidate -> {
			candidate.setStatus("pending");
			candidate.setCreatorStamp(LocalDateTime.now());
			candidate.setCreatorUser(userRepo.findByEmailId(emailId).get().getId());
		});
		hiringCandidateRepo.saveAll(candidates);

		return new APIResponse(HttpStatus.OK.value(), "Hired Candidates details added Successfully", candidates);

	}

	@Override
	public APIResponse viewCandidateProfile(String token, long id) {
		jwtUtil.verify(token);
		return new APIResponse(HttpStatus.OK.value(), hiringCandidateRepo.findById(id));
	}

	@Override
	public APIResponse updateCandidateStatus(String token, long id, String status) {
		jwtUtil.verify(token);
		HiringCandidate candidate = hiringCandidateRepo.findById(id).get();
		candidate.setStatus(status);
		return new APIResponse(HttpStatus.OK.value(), "Candidate status updated successfully", hiringCandidateRepo.save(candidate));
	}

	@Override
	public APIResponse getCandidatesCount(String token, String status) {
		jwtUtil.verify(token);
		List<HiringCandidate> candidates = hiringCandidateRepo.findByStatus(status).get();
		return new APIResponse(HttpStatus.OK.value(), candidates.size());
	}

	@Override
	public APIResponse getCandidateList(String token, String status) {
	   jwtUtil.verify(token);
	   List<HiringCandidate> candidates = hiringCandidateRepo.findByStatus(status).get();
		return new APIResponse(HttpStatus.OK.value(), candidates);
	}

	@Override
	public APIResponse getCandidateListByIDs(String token, List<Long> idList) {
		jwtUtil.verify(token);
		List<HiringCandidate> candidates = hiringCandidateRepo.findAllById(idList);
		return new APIResponse(HttpStatus.OK.value(), candidates);
	}

	@Override
	public APIResponse sendJobOfferNotification(String token, long id,String link) throws MessagingException {
		jwtUtil.verify(token);
		HiringCandidate candidate = hiringCandidateRepo.findById(id).get();
        emailSenderService.sendJobOffer(candidate,link);
		return new APIResponse(HttpStatus.OK.value(),"Email send successfully");
	}

}
