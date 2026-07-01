package com.example.fundamentals.provocari.c02;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("romanian3")
public class RomanianTranslator implements Translator {

    @Override
    public String translate(String name) {
        return "Salut, " + name + "!";
    }
}
