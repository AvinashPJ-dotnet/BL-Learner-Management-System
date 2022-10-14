package com.bl.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateBankDetailsDTO {
	private String name;
	private String account_number;
	private boolean is_account_number_verified;
	private boolean is_ifsc_code_verified;
	private String ifsc_code;
	private boolean is_pan_number_verified;
	private String pan_number;
	private boolean is_addhaar_number_verified;
	private String addhaar_number;
}
