package com.example.fundamentals.finala.f02;

import org.springframework.stereotype.Component;

@Component
public class NoDiscount implements Discount {

    @Override
    public int apply(int price) {
        return price;
    }

    @Override
    public String toString(){
        return "none";
    }
}
