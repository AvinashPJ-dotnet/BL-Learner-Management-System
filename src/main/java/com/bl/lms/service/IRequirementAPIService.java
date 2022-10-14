package com.bl.lms.service;

import java.util.List;

import com.bl.lms.dto.RequirementAPIDto;
import com.bl.lms.model.RequirementAPIData;

public interface IRequirementAPIService {

	List<RequirementAPIData> viewAllCompanyRequirement();

	RequirementAPIData viewCompanyRequirement(int id);

	RequirementAPIData newCompanyRequirement(RequirementAPIDto requirementAPIDto);

}
