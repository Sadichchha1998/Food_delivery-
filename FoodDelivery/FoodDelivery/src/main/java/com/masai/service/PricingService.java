package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.model.Pricing;
import com.masai.repository.PricingRepository;

@Service
public class PricingService {

    private PricingRepository pricingRepo;

    public int calculatePrice(Long organizationId, String zone, 
            int totalDistance, String itemType) {
        
        // Find pricing for organization, zone and itemType
        Pricing pricing = pricingRepo.findByOrganizationIdAndItemIdAndZone(
                                    organizationId, getItemId(itemType), zone);
        
        // Calculate price
        int basePrice = pricing.getBasePrice();
        int perKmPrice = pricing.getKmPrice();
        int extraDistance = totalDistance - pricing.getBaseDistanceInKm();
        int totalPrice = basePrice + (extraDistance * perKmPrice);

        return totalPrice;
    }

	private Long getItemId(String itemType) {
		// TODO Auto-generated method stub
		return null;
	}

}