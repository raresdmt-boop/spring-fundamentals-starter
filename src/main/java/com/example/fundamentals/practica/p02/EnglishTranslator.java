package com.example.fundamentals.practica.p02;

// Cerință:
// EnglishTranslator trebuie să fie ales default-ul când există mai multe
// implementări de Translator în context. greet(name) → "Hello, <name>!".

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("english")
@Primary
public class EnglishTranslator implements Translator {

    @Override
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
