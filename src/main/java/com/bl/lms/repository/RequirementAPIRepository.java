package com.bl.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bl.lms.model.RequirementAPIData;

public interface RequirementAPIRepository extends JpaRepository<RequirementAPIData, Long> {

}
