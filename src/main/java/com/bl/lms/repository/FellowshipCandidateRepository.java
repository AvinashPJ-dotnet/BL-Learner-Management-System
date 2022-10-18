package com.bl.lms.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bl.lms.model.FellowshipCandidate;

@Repository
public interface FellowshipCandidateRepository extends JpaRepository<FellowshipCandidate, Long>  {

	FellowshipCandidate findTopByOrderByIdDesc();

	@Query(value = "SELECT fc FROM FellowshipCandidate fc WHERE fc.candidateStatus = ?1")
	Collection<FellowshipCandidate> findByCandidateStatus(String status);

}
