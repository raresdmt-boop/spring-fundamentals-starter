package com.example.fundamentals.provocari.c09;

public class CardPayment implements PaymentStrategy {

    @Override
    public String pay(int amount) {
        return "CARD: " + amount;
    }
}
