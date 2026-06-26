package com.example.fundamentals.ex01;

// TODO: Adaugă adnotarea @Component peste clasă ca Spring să o descopere la
// component scan și să o publice ca bean în ApplicationContext.

public class GreetingService {

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
