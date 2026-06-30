package com.example.fundamentals.practica.p09;

import org.springframework.stereotype.Component;

import java.util.List;

// Cerință:
// UserRegistrationService trebuie să fie un bean Spring. În constructor cere
// `List<UserValidator>` — Spring va injecta AUTOMAT toate bean-urile care
// implementează UserValidator (fără să specifici @Qualifier sau @Primary).
// canRegister(username, password) întoarce true doar dacă TOATE validatoarele
// întorc true.
@Component
public class UserRegistrationService {

    private final List<UserValidator> userValidators;

    public UserRegistrationService(List<UserValidator> userValidators) {
        this.userValidators = userValidators;
    }

    public boolean canRegister(String username, String password) {
        for  (UserValidator userValidator : userValidators) {
            if(!userValidator.isValid(username, password)) {
                return false;
            }
        };
        return true;
    }
}
