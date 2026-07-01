package com.example.fundamentals.provocari.c07;

import org.springframework.stereotype.Component;

@Component("email3")
public class EmailValidator implements Validator {

    @Override
    public boolean validate(String input) {
        return input != null && input.contains("@");
    }
}
