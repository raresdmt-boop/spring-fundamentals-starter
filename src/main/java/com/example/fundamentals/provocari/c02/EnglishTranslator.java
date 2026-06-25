package com.example.fundamentals.provocari.c02;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class EnglishTranslator implements Translator {

    @Override
    public String translate(String name) {
        return "Hello, " + name + "!";
    }
}
