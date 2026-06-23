package com.example.fundamentals.finala.f01;

public class LogMiddleware implements Middleware {

    @Override
    public String handle(String payload) {
        return payload + "[log]";
    }
}
