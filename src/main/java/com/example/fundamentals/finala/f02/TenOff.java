package com.example.fundamentals.finala.f02;

public class TenOff implements Discount {

    @Override
    public int apply(int price) {
        return price - 10;
    }
}
