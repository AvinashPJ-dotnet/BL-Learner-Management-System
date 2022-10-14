package com.bl.lms.service;

import java.util.List;

import com.bl.lms.model.RequirementAPIData;

public interface IRequirementAPIService {

	List<RequirementAPIData> getRequirementAPIDatas();

	RequirementAPIData getRequirementAPIDatasById(int id);

}
