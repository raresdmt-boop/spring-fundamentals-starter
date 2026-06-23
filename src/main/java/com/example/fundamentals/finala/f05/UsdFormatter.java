package com.example.fundamentals.finala.f05;

public class UsdFormatter implements MoneyFormatter {

    @Override
    public String format(int cents) {
        return "$" + cents;
    }
}
