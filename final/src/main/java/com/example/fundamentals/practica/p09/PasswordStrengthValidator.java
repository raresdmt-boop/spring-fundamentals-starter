package com.example.fundamentals.practica.p09;

import org.springframework.stereotype.Component;

@Component
public class PasswordStrengthValidator implements UserValidator {

    @Override
    public boolean isValid(String username, String password) {
        return password.length() >= 8;
    }
}
