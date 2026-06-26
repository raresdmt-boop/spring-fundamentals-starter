package com.example.fundamentals.practica.p09;

// Cerință: bean Spring care întoarce true dacă password are cel puțin 8 caractere.

public class PasswordStrengthValidator implements UserValidator {

    @Override
    public boolean isValid(String username, String password) {
        return false;
    }
}
