package com.bl.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bl.lms.model.CandidateBankDetails;
@Repository
public interface CandidateBankDetailsRepository extends JpaRepository<CandidateBankDetails, Long>  {

}
