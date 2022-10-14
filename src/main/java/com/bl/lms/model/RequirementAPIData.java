package com.bl.lms.model;

import lombok.Data;
import javax.persistence.*;

import com.bl.lms.dto.RequirementAPIDto;

import java.util.List;

@Entity
@Table(name = "Requirement")
public @Data class RequirementAPIData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", nullable = false)
	private int id;
	private String companyName;
	private String requestMonth;
	private String city;
	private String requirementPath;
	private String documentVerification;
	private String techRequirements;
	@ElementCollection
	@CollectionTable(name = "TechRequirements", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "totalEngineers")
	private List<String> TechRequirements;

	public RequirementAPIData(int id, RequirementAPIDto requirementAPIDto) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.requestMonth = requestMonth;
		this.city = city;
		this.requirementPath = requirementPath;
		this.documentVerification = documentVerification;
		this.techRequirements = techRequirements;
	}

}
