package com.example.fundamentals.practica.p09;

import java.util.List;

// Cerință:
// UserRegistrationService trebuie să fie un bean Spring. În constructor cere
// `List<UserValidator>` — Spring va injecta AUTOMAT toate bean-urile care
// implementează UserValidator (fără să specifici @Qualifier sau @Primary).
// canRegister(username, password) întoarce true doar dacă TOATE validatoarele
// întorc true.

public class UserRegistrationService {

    public boolean canRegister(String username, String password) {
        return false;
    }
}
