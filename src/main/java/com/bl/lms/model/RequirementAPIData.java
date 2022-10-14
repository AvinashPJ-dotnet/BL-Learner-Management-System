package com.bl.lms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Requirement_db")

public @Data class RequirementAPIData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "companyName")
	private String companyName;
	private String requestMonth;
	private String city;
	private String requirementPath;
	private String documentVerification;
	private String techRequirements;
	
	@ElementCollection
    @CollectionTable(name = "TechRequirement_db", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "TechRequirement")
    private List<String> TechRequirement;

	 public RequirementAPIData() {

	    }
}
