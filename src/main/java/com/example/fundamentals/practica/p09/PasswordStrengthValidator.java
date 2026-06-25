package com.example.fundamentals.practica.p09;

import org.springframework.stereotype.Component;

// Cerință: bean Spring care întoarce true dacă password are cel puțin 8 caractere.
@Component("passwordValidator")
public class PasswordStrengthValidator implements UserValidator {

    @Override
    public boolean isValid(String username, String password) {
        return password.length() >= 8;
    }
}
