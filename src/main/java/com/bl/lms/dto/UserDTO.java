package com.bl.lms.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private String firstName;
	private String lastName;
	private String emailId;
	private String mobile;
	private String profilePath;
	private String password;
	private String role;
}
