package com.example.fundamentals.provocari.c02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class Welcomer {

    private final Translator translator;

    public Welcomer(Translator translator) {
        this.translator = translator;
    }

    public String welcome(String name) {
        return translator.translate(name);
    }
}
