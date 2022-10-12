package com.bl.lms.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Company_Requirement")
public @Data class RequirementAPIModel {

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

}
