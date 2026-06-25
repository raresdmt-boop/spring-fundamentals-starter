package com.example.fundamentals.finala.f01;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AuthMiddleware implements Middleware {

    @Override
    public String handle(String payload) {
        return payload + "[auth]";
    }
}
