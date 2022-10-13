package com.bl.lms.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIResponse {

	private Integer status;
	private String message;
	private Object data;

	public APIResponse(Integer status, String message) {
		this.status = status;
		this.message = message;
	}

}
