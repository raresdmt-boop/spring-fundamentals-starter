package com.example.fundamentals.provocari.c02;

public class EnglishTranslator implements Translator {

    @Override
    public String translate(String name) {
        return "Hello, " + name + "!";
    }
}
