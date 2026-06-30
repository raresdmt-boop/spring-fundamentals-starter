package com.example.fundamentals.practica.p02;

import org.springframework.stereotype.Component;

// Cerință:
// Welcomer trebuie să fie un bean Spring care primește un Translator prin
// constructor — FĂRĂ @Qualifier. welcome(name) delegă către translator.greet(name).
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
