package com.example.debug.d01;

import org.springframework.stereotype.Component;

@Component
public class GreetingClient {

    private final GreetingService greetingService;

    public GreetingClient(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String send(String name) {
        return greetingService.greet(name);
    }
}
