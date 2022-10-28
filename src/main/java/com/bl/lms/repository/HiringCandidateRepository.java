package com.bl.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bl.lms.model.HiringCandidate;


public interface HiringCandidateRepository extends JpaRepository<HiringCandidate,Long>{
	
	public Optional<HiringCandidate> findByEmailId(String emailId);
	public Optional<List<HiringCandidate>> findByStatus(String status);
}
