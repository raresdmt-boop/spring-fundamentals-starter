package com.example.fundamentals.provocari.c02;

public class EngTranslator implements Translator {

    @Override
    public String translate(String name) {
        return "Hello, " + name + "!";
    }
}
