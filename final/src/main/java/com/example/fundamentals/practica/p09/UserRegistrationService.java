package com.example.fundamentals.practica.p09;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistrationService {

    private final List<UserValidator> validators;

    public UserRegistrationService(List<UserValidator> validators) {
        this.validators = validators;
    }

    public boolean canRegister(String username, String password) {
        return validators.stream().allMatch(v -> v.isValid(username, password));
    }
}
