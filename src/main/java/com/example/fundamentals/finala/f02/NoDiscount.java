package com.example.fundamentals.finala.f02;

public class NoDiscount implements Discount {

    @Override
    public int apply(int price) {
        return price;
    }
}
