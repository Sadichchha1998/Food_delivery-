package com.masai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.PricingService;

@RestController
@RequestMapping("/pricing") 
public class PricingController {

    private PricingService pricingService;

    @GetMapping
    public int calculate(@RequestParam Long organizationId, 
            @RequestParam String zone,  
            @RequestParam int totalDistance, 
            @RequestParam String itemType) {
                
        return pricingService.calculatePrice(organizationId, zone, totalDistance, itemType);
    }

}