package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Pricing;

public interface PricingRepository extends JpaRepository<Pricing, Long> {

    public Pricing findByOrganizationIdAndItemIdAndZone(
            Long organizationId, Long itemId, String zone);

	public Pricing findByOrganizationIdAndZoneAndItemType(Long organizationId, String zone, String itemType);

}