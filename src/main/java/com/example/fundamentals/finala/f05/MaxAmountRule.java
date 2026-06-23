package com.example.fundamentals.finala.f05;

public class MaxAmountRule implements BillingRule {

    @Override
    public boolean ok(int amountCents) {
        return amountCents <= 1_000_000;
    }
}
