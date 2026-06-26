package com.example.fundamentals.ex06;

import org.springframework.stereotype.Component;

@Component
public class Checkout {

    private final PaymentGateway gateway;

    public Checkout(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public String pay(int amountCents) {
        return gateway.charge(amountCents);
    }
}
