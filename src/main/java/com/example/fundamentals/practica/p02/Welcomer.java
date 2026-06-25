package com.example.fundamentals.practica.p02;

// Cerință:
// Welcomer trebuie să fie un bean Spring care primește un Translator prin
// constructor — FĂRĂ @Qualifier. welcome(name) delegă către translator.greet(name).

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Welcomer {
    Translator translator;

    Welcomer(Translator translator){
        this.translator = translator;
    }

    public String welcome(String name) {
        return translator.greet(name);
    }
}
