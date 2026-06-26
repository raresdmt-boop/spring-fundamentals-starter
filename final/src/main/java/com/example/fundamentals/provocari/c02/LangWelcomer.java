package com.example.fundamentals.provocari.c02;

import org.springframework.stereotype.Component;

@Component
public class LangWelcomer {

    private final Translator translator;

    public LangWelcomer(Translator translator) {
        this.translator = translator;
    }

    public String welcome(String name) {
        return translator.translate(name);
    }
}
