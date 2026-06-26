package com.example.fundamentals.ex05;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    private final String greeting;

    public AppProperties(@Value("${app.greeting}") String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }
}
