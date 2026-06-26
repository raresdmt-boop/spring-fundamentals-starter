package com.example.fundamentals.provocari.c09;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentResolver {

    private final Map<String, PaymentStrategy> strategies;

    public PaymentResolver(Map<String, PaymentStrategy> strategies) {
        this.strategies = strategies;
    }

    public PaymentStrategy resolve(String key) {
        return strategies.get(key);
    }
}
