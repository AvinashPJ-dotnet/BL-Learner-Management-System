package com.bl.lms.service;

import javax.mail.MessagingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.UserDTO;
import com.bl.lms.exception.UserException;
import com.bl.lms.model.User;
import com.bl.lms.repository.UserRepository;
import com.bl.lms.utils.EmailSenderService;
import com.bl.lms.utils.OTPService;



@Service
public class UserService implements IUserService{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	EmailSenderService emailService;
	
	@Autowired
    OTPService otpService;
	
   
	public UserDTO convertUserEntityToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}
	
	@Override
	public APIResponse signUp(User user) {
		
		userRepo.findByEmailId(user.getEmailId()).ifPresent((existingUser) -> {
			throw new UserException("Account already exists");
		});
		User registeredUser= userRepo.save(user);
		UserDTO userDTO = convertUserEntityToDTO(registeredUser);
		
		return new APIResponse(HttpStatus.OK.value(),"Account created successfully",userDTO);
		
	}

	
	public String generateOTP(String emailId) throws MessagingException {
	
		User user = userRepo.findByEmailId(emailId).get();
		int otp = otpService.generateOTP(emailId);
		emailService.sendOtpMessage(user, otp);
		return "Otp generated";
	}

	@Override
	public APIResponse validateOtp(String emailId, int otpnum) {
		final String SUCCESS = "Entered Otp is valid";
		final String FAIL = "Entered Otp is NOT valid. Please Retry!";
		if(otpnum >= 0){
			
		  int serverOtp = otpService.getOtp(emailId);
			if(serverOtp > 0){
			  if(otpnum == serverOtp){
				  otpService.clearOTP(emailId);
				  return new APIResponse(HttpStatus.OK.value(),SUCCESS);
					 
				} 
				else {
					return new APIResponse(HttpStatus.OK.value(),FAIL);
					
					
				   }
			   }else {
				   return new APIResponse(HttpStatus.OK.value(),FAIL);
					
			 
			   }
			 }else {
				 return new APIResponse(HttpStatus.OK.value(),FAIL);
					
		 }

	
	}

	@Override
	public APIResponse login(String emailId, String password) throws MessagingException {
			userRepo.findByEmailIdAndByPassword(emailId, password)
					.orElseThrow(() -> new UserException("Incorrect email or password"));
		String message = generateOTP(emailId);
		User user = userRepo.findByEmailId(emailId).get();
		return new APIResponse(HttpStatus.OK.value(),message,user.getRole());
		
	}
}
