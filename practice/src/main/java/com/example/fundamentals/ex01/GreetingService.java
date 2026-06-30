package com.example.fundamentals.ex01;

import org.springframework.stereotype.Component;

// TODO: Adaugă adnotarea @Component peste clasă ca Spring să o descopere la
// component scan și să o publice ca bean în ApplicationContext.
@Component
public class GreetingService {

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
