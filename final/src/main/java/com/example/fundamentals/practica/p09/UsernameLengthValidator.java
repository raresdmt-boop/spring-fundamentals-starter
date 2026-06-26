package com.example.fundamentals.practica.p09;

import org.springframework.stereotype.Component;

@Component
public class UsernameLengthValidator implements UserValidator {

    @Override
    public boolean isValid(String username, String password) {
        return username.length() >= 3;
    }
}
