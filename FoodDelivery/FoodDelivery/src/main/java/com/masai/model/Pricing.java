package com.masai.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
@Data
@Entity
@Table(name = "pricing")
public class Pricing {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long organizationId;

    @NotNull
    private Long itemId;

    @NotNull
    private String zone;
    
    @NotNull
    private Integer baseDistanceInKm;
    
    @NotNull
    private Integer kmPrice;
    
    @NotNull 
    private Integer basePrice;

}