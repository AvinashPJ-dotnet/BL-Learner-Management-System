package com.bl.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.lms.service.IAdminService;

@RestController
@RequestMapping("/lms")
public class AdminController {

	@Autowired
	IAdminService adminService;
	
	
}
