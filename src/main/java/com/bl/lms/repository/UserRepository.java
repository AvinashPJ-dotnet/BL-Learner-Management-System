package com.bl.lms.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bl.lms.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByEmailId(String emailId);
	
	@Query("SELECT u FROM User u WHERE u.emailId = ?1 and u.password = ?2")
	public Optional<User> findByEmailIdAndByPassword(String emailId, String password);

	public User findByResetPasswordToken(String token);
}
