package com.example.fundamentals.provocari.c02;

import org.springframework.stereotype.Component;

@Component
public class RomanianTranslator implements Translator {

    @Override
    public String translate(String name) {
        return "Salut, " + name + "!";
    }
}
