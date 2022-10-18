package com.bl.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateBankDetailsDTO {
	private String name;
	private String accountNumber;
	private boolean isAccountNumberVerified;
	private boolean isIfscCodeVerified;
	private String ifscCode;
	private boolean isPanNumberVerified;
	private String panNumber;
	private boolean is_addhaarNumberVerified;
	private String addhaarNumber;
}
