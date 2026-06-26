package com.example.fundamentals.provocari.c09;

import org.springframework.stereotype.Component;

@Component("paypal")
public class PaypalPayment implements PaymentStrategy {

    @Override
    public String pay(int amount) {
        return "PAYPAL: " + amount;
    }
}
