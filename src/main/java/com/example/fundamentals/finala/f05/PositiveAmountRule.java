package com.example.fundamentals.finala.f05;

public class PositiveAmountRule implements BillingRule {

    @Override
    public boolean ok(int amountCents) {
        return amountCents > 0;
    }
}
