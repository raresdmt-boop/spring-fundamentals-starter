package com.example.fundamentals.practica.p02;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EnglishTranslator implements Translator {

    @Override
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
