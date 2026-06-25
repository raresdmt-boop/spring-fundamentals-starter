package com.example.fundamentals.practica.p02;

// Cerință:
// FrenchTranslator e o alternativă disponibilă în context, dar NU e cea aleasă
// implicit. greet(name) → "Bonjour, <name>!".

import org.springframework.stereotype.Component;

@Component("romanian")
public class FrenchTranslator implements Translator {

    @Override
    public String greet(String name) {
        return "Bonjour, " + name + "!";
    }
}
