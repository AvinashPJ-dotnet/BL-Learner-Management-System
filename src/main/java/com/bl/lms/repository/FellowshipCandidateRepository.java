package com.bl.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bl.lms.model.FellowshipCandidate;

@Repository
public interface FellowshipCandidateRepository extends JpaRepository<FellowshipCandidate, Long>  {

	FellowshipCandidate findTopByOrderByIdDesc();

//	@Query("SELECT u FROM Fellowship_Candidate u WHERE u.candidate_status = ?1")
//	List<FellowshipCandidate> findByCandidateStatus(String status);

}
