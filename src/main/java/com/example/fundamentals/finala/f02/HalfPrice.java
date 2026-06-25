package com.example.fundamentals.finala.f02;

import org.springframework.stereotype.Component;

@Component
public class HalfPrice implements Discount {

    @Override
    public int apply(int price) {
        return price / 2;
    }

    @Override
    public String toString(){
        return "half";
    }
}
