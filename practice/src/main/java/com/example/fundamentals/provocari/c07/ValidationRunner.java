package com.example.fundamentals.provocari.c07;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidationRunner {

    private final List<Validator>  validators;

    public ValidationRunner(List<Validator> validators) {
        this.validators = validators;
    }

    public boolean runAll(String input) {

        for (Validator validator : validators) {
            if(!validator.validate(input))
                return false;
        };
        return true;
    }
}
