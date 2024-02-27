package com.masai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.DeliveryCostService;

@RestController
@RequestMapping("/delivery")  
public class DeliveryController {

    private DeliveryCostService deliveryCostService;

    @GetMapping("/calculate-cost")
    public DeliveryController calculate(@RequestParam Long organizationId, 
                                  @RequestParam String zone, 
                                  @RequestParam int distance,
                                  @RequestParam String itemType) {
        
       return deliveryCostService.calculateCost(organizationId, zone, distance, itemType);
        
    }
}