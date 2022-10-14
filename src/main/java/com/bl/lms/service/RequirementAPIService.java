package com.bl.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bl.lms.dto.RequirementAPIDto;
import com.bl.lms.model.RequirementAPIData;
import com.bl.lms.repository.RequirementAPIRepository;

public class RequirementAPIService implements IRequirementAPIService {

	@Autowired
	RequirementAPIRepository requirementAPIRepository;

	private List<RequirementAPIData> requirementAPIDatas = new ArrayList<>();

	@Override
	public List<RequirementAPIData> viewAllCompanyRequirement() {
		return requirementAPIDatas;
	}

	@Override
	public RequirementAPIData viewCompanyRequirement(int id) {
		return requirementAPIDatas.get(id);
	}

	@Override
	public RequirementAPIData newCompanyRequirement(RequirementAPIDto requirementAPIDto) {
		RequirementAPIData requirementAPIData = null;
		requirementAPIData = new RequirementAPIData(((List<RequirementAPIData>) requirementAPIData).size() + 1,
				requirementAPIDto);
		((List<RequirementAPIData>) requirementAPIData).add(requirementAPIData);
		return requirementAPIData;
	}

}
