package com.example.fundamentals.practica.p02;

import org.springframework.stereotype.Component;

@Component
public class FrenchTranslator implements Translator {

    @Override
    public String greet(String name) {
        return "Bonjour, " + name + "!";
    }
}
