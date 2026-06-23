package com.example.fundamentals.finala.f01;

public class CompressMiddleware implements Middleware {

    @Override
    public String handle(String payload) {
        return payload + "[zip]";
    }
}
