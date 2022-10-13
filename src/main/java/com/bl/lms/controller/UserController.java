package com.bl.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bl.lms.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.mail.MessagingException;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.model.User;
import com.bl.lms.service.IUserService;

@RestController
@RequestMapping("/lms")
public class UserController {

	@Autowired
	IUserService userService;

	
	@PostMapping("/signup")
	public APIResponse signUp(@RequestBody User user) {
		return userService.signUp(user);
	}

	@PostMapping("/login/{emailId}/{password}")
	public APIResponse login(@PathVariable String emailId, @PathVariable String password)
			throws MessagingException {
		return userService.login(emailId, password);
	}

	@GetMapping("/generateOtp/{emailId}")
	public ResponseEntity<String> generateOTP(@PathVariable String emailId) throws MessagingException{
	return ResponseEntity.status(HttpStatus.OK).body(userService.generateOTP(emailId));
	}

	@GetMapping("/validateOtp/{emailId}")
	public APIResponse validateOtp(@RequestParam("otpnum") int otpnum, @PathVariable String emailId) {
		return userService.validateOtp(emailId, otpnum);
	}

}
