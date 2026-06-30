package com.example.fundamentals.practica.p10;

// Cerință:
// Stopwatch trebuie să fie un bean Spring care:
//   - la construire/pornire înregistrează timpul curent în câmpul `startedAt`
//     (folosește System.currentTimeMillis())
//   - metoda startedAt() întoarce valoarea înregistrată
//   - metoda elapsed() întoarce câte millisecunde au trecut de la pornire
//
// Înregistrarea trebuie să fie făcută AUTOMAT de Spring după ce bean-ul e
// construit complet, NU în constructor.

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Stopwatch {

    private long startedAt;

    @PostConstruct
    public long startedAt() {
        return System.currentTimeMillis();
    }

    public long elapsed() {
        return System.currentTimeMillis() - startedAt;
    }
}
