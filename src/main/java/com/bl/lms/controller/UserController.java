package com.bl.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.lms.dto.UserDTO;
import com.bl.lms.service.IUserService;

@RestController
@RequestMapping("/lms")
public class UserController {

	@Autowired
	IUserService userService;
	
	public ResponseEntity<String> signUp(@RequestBody UserDTO user){
		userService.signUp(user);
		return ResponseEntity.status(HttpStatus.OK).body("Account created Successfully");
		
	}
	
}
