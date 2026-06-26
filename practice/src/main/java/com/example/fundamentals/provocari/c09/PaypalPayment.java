package com.example.fundamentals.provocari.c09;

public class PaypalPayment implements PaymentStrategy {

    @Override
    public String pay(int amount) {
        return "PAYPAL: " + amount;
    }
}
