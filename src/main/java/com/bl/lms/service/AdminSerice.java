package com.bl.lms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bl.lms.repository.AdminRepository;

public class AdminSerice implements IAdminService{

	@Autowired
	AdminRepository adminRepo;
}
