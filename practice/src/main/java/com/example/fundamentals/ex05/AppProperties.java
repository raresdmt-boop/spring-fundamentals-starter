package com.example.fundamentals.ex05;

// TODO:
//   1. Marchează clasa cu @Component ca Spring să o descopere ca bean.
//   2. Pe parametrul `greeting` din constructor adaugă
//      @Value("${app.greeting}") ca Spring să injecteze valoarea proprietății
//      `app.greeting` din application.yaml.
//      → Dacă proprietatea lipsește din yaml, Spring eșuează la pornire cu
//        eroare explicită. Poți da default cu @Value("${app.greeting:Hi}").

public class AppProperties {

    private final String greeting;

    public AppProperties(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }
}
