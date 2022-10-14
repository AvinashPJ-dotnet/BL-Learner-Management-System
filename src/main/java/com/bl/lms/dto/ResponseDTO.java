package com.bl.lms.dto;

import lombok.Data;

 @Data 
 public class ResponseDTO {


	private String message;
	private Object data;

	public ResponseDTO(String string, Object payrollData) {
		this.message = string;
		this.data = payrollData;
	}





}