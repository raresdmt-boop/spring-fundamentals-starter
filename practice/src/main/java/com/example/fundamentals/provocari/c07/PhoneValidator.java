package com.example.fundamentals.provocari.c07;

public class PhoneValidator implements Validator {

    @Override
    public boolean validate(String input) {
        return input != null && input.contains("+");
    }
}
