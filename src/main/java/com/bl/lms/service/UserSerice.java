package com.bl.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.lms.dto.UserDTO;
import com.bl.lms.repository.UserRepository;

@Service
public class UserSerice implements IUserService{

	@Autowired
	UserRepository userRepo;

	@Override
	public void signUp(UserDTO user) {
		userRepo.findByEmailId(user).ifPresent((existingCus) -> {
			throw new CustomerException("Account already exists");
		});
		return customerRepo.save(customer);
	}
}
