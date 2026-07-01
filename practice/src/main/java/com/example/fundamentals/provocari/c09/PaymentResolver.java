package com.example.fundamentals.provocari.c09;

import org.springframework.stereotype.Component;

@Component
public class PaymentResolver {

    public PaymentStrategy resolve(String key) {
        if (key.equals("card")) {
            return new CardPayment();
        };
        if (key.equals("paypal")) {
            return new PaypalPayment();
        }
        return null;
    }
}
