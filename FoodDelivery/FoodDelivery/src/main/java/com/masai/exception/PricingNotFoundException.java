package com.masai.exception;

public class PricingNotFoundException extends RuntimeException {

    public PricingNotFoundException() {
        super("Pricing not found");
    }

}