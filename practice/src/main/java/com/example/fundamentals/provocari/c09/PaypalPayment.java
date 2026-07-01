package com.example.fundamentals.provocari.c09;

import org.springframework.stereotype.Component;

@Component("paypal3")
public class PaypalPayment implements PaymentStrategy {

    @Override
    public String pay(int amount) {
        return "PAYPAL: " + amount;
    }
}
