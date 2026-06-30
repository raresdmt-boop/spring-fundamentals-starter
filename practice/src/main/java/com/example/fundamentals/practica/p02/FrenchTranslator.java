package com.example.fundamentals.practica.p02;

import org.springframework.stereotype.Component;

// Cerință:
// FrenchTranslator e o alternativă disponibilă în context, dar NU e cea aleasă
// implicit. greet(name) → "Bonjour, <name>!".
@Component("french")
public class FrenchTranslator implements Translator {

    @Override
    public String greet(String name) {
        return "Bonjour, " + name + "!";
    }
}
