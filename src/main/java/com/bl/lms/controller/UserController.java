package com.bl.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.mail.MessagingException;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.model.User;
import com.bl.lms.service.interfaces.IUserService;



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

//	@PostMapping("/forgot_password")
//	public String processForgotPassword(String emailId) {
//	    
//	    String token = RandomString.make(30);
//	     
//	    try {
//	        userService.updateResetPasswordToken(token, emailId);
//	        String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
//	        sendEmail(emailId, resetPasswordLink);
//	        model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
//	         
//	    } catch (CustomerNotFoundException ex) {
//	        model.addAttribute("error", ex.getMessage());
//	    } catch (UnsupportedEncodingException | MessagingException e) {
//	        model.addAttribute("error", "Error while sending email");
//	    }
//	         
//	    return "forgot_password_form";
//	}
//	
//	@PostMapping("/reset_password")
//	public String processResetPassword(HttpServletRequest request, Model model) {
//	    String token = request.getParameter("token");
//	    String password = request.getParameter("password");
//	     
//	    Customer customer = customerService.getByResetPasswordToken(token);
//	    model.addAttribute("title", "Reset your password");
//	     
//	    if (customer == null) {
//	        model.addAttribute("message", "Invalid Token");
//	        return "message";
//	    } else {           
//	        customerService.updatePassword(customer, password);
//	         
//	        model.addAttribute("message", "You have successfully changed your password.");
//	    }
//	     
//	    return "message";
//	}
}
