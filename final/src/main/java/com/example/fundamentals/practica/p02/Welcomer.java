package com.example.fundamentals.practica.p02;

import org.springframework.stereotype.Component;

@Component
public class Welcomer {

    private final Translator translator;

    public Welcomer(Translator translator) {
        this.translator = translator;
    }

    public String welcome(String name) {
        return translator.greet(name);
    }
}
