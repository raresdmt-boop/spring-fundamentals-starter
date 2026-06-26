package com.example.fundamentals.practica.p09;

// Cerință: bean Spring care întoarce true dacă username are cel puțin 3 caractere.

public class UsernameLengthValidator implements UserValidator {

    @Override
    public boolean isValid(String username, String password) {
        return false;
    }
}
