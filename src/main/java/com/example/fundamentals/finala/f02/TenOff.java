package com.example.fundamentals.finala.f02;

import org.springframework.stereotype.Component;

@Component
public class TenOff implements Discount {

    @Override
    public int apply(int price) {
        return price - 10;
    }
    @Override
    public String toString(){
        return "tenoff";
    }
}
