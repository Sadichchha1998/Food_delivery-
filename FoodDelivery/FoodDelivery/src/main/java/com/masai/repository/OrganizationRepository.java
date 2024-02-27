package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	void findByOrganizationAndZoneAndItemType();
}