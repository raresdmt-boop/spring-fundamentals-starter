package com.example.fundamentals.finala.f01;

public class AuthMiddleware implements Middleware {

    @Override
    public String handle(String payload) {
        return payload + "[auth]";
    }
}
