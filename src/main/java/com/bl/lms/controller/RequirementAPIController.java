package com.bl.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.lms.dto.ResponseDTO;
import com.bl.lms.model.RequirementAPIData;
import com.bl.lms.service.IRequirementAPIService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("RequirementAPIctroller")
@Slf4j
public class RequirementAPIController {
	@Autowired
	private IRequirementAPIService iRequirementAPIService;

	@Autowired
	@GetMapping("/requirement")
	public List<RequirementAPIData> getRequirementAPIDatas() {
		List<RequirementAPIData> apiDatas = iRequirementAPIService.getRequirementAPIDatas();
		return apiDatas;
	}

	@GetMapping("/requirement/{id}")
	public ResponseEntity<ResponseDTO> getRequirementAPIDatasById(@PathVariable int id) {
		List<RequirementAPIData> apiDatas = null;
		apiDatas = (List<RequirementAPIData>) iRequirementAPIService.getRequirementAPIDatasById(id);
		ResponseDTO response = new ResponseDTO("Get Call for gender Successful", apiDatas);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
}