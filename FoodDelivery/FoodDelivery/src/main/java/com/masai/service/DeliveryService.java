package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.PricingNotFoundException;
import com.masai.model.Pricing;
import com.masai.repository.PricingRepository;

@Service
public class DeliveryService {

    @Autowired
    private PricingRepository pricingRepo;

    public int calculatePrice(Long organizationId, String zone, int totalDistance, String itemType) {
        
        // Find applicable pricing
        Pricing pricing = pricingRepo.findByOrganizationIdAndZoneAndItemType(organizationId, zone, itemType);
        
        if (pricing == null) {
            throw new PricingNotFoundException();
        }
        
        int basePrice = pricing.getBasePrice();
        int kmPrice = pricing.getBasePrice(); 
        int baseDistance = pricing.getBaseDistanceInKm();
        int extraDistance = totalDistance - baseDistance;
        int extraPrice = extraDistance * kmPrice;
        
        return basePrice + extraPrice; 
    }

	public void setTotalPrice(int totalPrice) {
		// TODO Auto-generated method stub
		
	}

}
