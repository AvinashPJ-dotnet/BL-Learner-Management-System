package com.bl.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bl.lms.model.RequirementAPIData;
import com.bl.lms.repository.RequirementAPIRepository;

public class RequirementAPIService implements IRequirementAPIService {

	@Autowired
	RequirementAPIRepository requirementAPIRepository;

	private List<RequirementAPIData> requirementAPIDatas = new ArrayList<>();

	@Override
	public List<RequirementAPIData> getRequirementAPIDatas() {
		return requirementAPIDatas;
	}

	@Override
	public RequirementAPIData getRequirementAPIDatasById(int id) {
		return requirementAPIDatas.get(id);
	}
}
