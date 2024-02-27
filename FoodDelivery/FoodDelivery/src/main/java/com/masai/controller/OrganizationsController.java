package com.masai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Organization;
import com.masai.service.OrganizationsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/organizations")
public class OrganizationsController {

    private OrganizationsService organizationsService;

    @PostMapping
    public Organization create(@RequestBody @Valid Organization organization) {
        return organizationsService.create(organization);
    }
    
    @GetMapping("/{organizationId}")
    public Organization get(@PathVariable Long organizationId) {
        return organizationsService.get(organizationId);
    }
    
    @PutMapping("/{organizationId}")
    public Organization update(@PathVariable Long organizationId, 
                               @RequestBody @Valid Organization organization) {
        return organizationsService.update(organizationId, organization);  
    }
    
    @DeleteMapping("/{organizationId}")
    public ResponseEntity<?> delete(@PathVariable Long organizationId) {
        return organizationsService.delete(organizationId);
    }

}