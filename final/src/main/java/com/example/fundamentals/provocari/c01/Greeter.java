package com.example.fundamentals.provocari.c01;

import org.springframework.stereotype.Component;

@Component
public class Greeter {

    public String greet(String name) {
        return "Salut, " + name + "!";
    }
}
