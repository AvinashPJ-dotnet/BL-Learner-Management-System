package com.bl.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bl.lms.dto.UserDTO;
import com.bl.lms.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByEmailId(UserDTO user);
}
