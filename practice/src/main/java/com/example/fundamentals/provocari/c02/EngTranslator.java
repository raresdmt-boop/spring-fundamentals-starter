package com.example.fundamentals.provocari.c02;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("english")
@Primary
public class EngTranslator implements Translator {

    @Override
    public String translate(String name) {
        return "Hello, " + name + "!";
    }
}
