package com.bl.lms.service;

import javax.mail.MessagingException;
import com.bl.lms.dto.APIResponse;
import com.bl.lms.model.User;

public interface IUserService {

	public APIResponse signUp(User user);

	public String generateOTP(String emailId) throws MessagingException;

	public APIResponse validateOtp(String emailId, int otpnum);

	public APIResponse login(String emailId, String password) throws MessagingException;

}
