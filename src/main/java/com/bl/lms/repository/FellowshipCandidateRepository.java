package com.bl.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bl.lms.model.FellowshipCandidate;

@Repository
public interface FellowshipCandidateRepository extends JpaRepository<FellowshipCandidate, Long>  {

	FellowshipCandidate findTopByOrderByIdDesc();

}
