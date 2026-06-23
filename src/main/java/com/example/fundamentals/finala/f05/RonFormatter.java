package com.example.fundamentals.finala.f05;

public class RonFormatter implements MoneyFormatter {

    @Override
    public String format(int cents) {
        return cents + " RON";
    }
}
