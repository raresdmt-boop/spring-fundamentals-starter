package com.example.fundamentals.provocari.c03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VatCalculator {

    private final double rate;

    public VatCalculator(@Value("${app.vat.rate:0}") double rate) {
        this.rate = rate;
    }

    public double calculate(double amount) {
        return amount * rate;
    }
}
