package com.bl.lms.dto;

import lombok.Data;

public @Data class ResponseDTO {

<<<<<<< HEAD
	private String message;
	private Object data;

	public ResponseDTO(String string, Object payrollData) {
		this.message = string;
		this.data = payrollData;
	}
=======
    private String message;
    private Object data;

    public ResponseDTO(String string, Object payrollData) {
        this.message = string;
        this.data = payrollData;
    }
>>>>>>> Hiring_Module_Added_Model_001
}