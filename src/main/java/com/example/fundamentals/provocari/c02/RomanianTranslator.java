package com.example.fundamentals.provocari.c02;

public class RomanianTranslator implements Translator {

    @Override
    public String translate(String name) {
        return "Salut, " + name + "!";
    }
}
