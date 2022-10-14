package com.bl.lms.service.interfaces;

import com.bl.lms.dto.APIResponse;
import com.bl.lms.dto.CandidateBankDetailsDTO;

public interface ICandidateBankDetailsService {

	APIResponse addBankDetails(String candidate_id, CandidateBankDetailsDTO bankDetails);

	APIResponse updateBankDetails(String candidate_id, CandidateBankDetailsDTO bankDetails);

	APIResponse getBankDetails(String candidate_id);

}
