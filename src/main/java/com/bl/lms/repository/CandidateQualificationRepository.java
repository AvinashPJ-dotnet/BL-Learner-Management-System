package com.bl.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bl.lms.model.CandidateQualification;

@Repository
public interface CandidateQualificationRepository extends JpaRepository<CandidateQualification, Long> {

}
