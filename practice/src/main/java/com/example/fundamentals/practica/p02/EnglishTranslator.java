package com.example.fundamentals.practica.p02;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Cerință:
// EnglishTranslator trebuie să fie ales default-ul când există mai multe
// implementări de Translator în context. greet(name) → "Hello, <name>!".
@Component("english2")
@Primary
public class EnglishTranslator implements Translator {

    @Override
    public String greet(String name) {
        return "Hello, "+name+"!";
    }
}
