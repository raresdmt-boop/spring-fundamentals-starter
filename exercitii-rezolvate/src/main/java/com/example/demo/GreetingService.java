package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final String greetingPrefix;

    public GreetingService(@Value("${app.greeting}") String greetingPrefix) {
        this.greetingPrefix = greetingPrefix;
        System.out.println("    [@Service] GreetingService instantiated — primit greeting='" + greetingPrefix + "' via @Value");
    }

    public String greet(String name) {
        return greetingPrefix + " — " + name;
    }
}
