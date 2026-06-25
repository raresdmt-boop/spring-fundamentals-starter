package com.example.fundamentals.practica.p10;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Cerință:
// Stopwatch trebuie să fie un bean Spring care:
//   - la construire/pornire înregistrează timpul curent în câmpul `startedAt`
//     (folosește System.currentTimeMillis())
//   - metoda startedAt() întoarce valoarea înregistrată
//   - metoda elapsed() întoarce câte millisecunde au trecut de la pornire
//
// Înregistrarea trebuie să fie făcută AUTOMAT de Spring după ce bean-ul e
// construit complet, NU în constructor.
@Component
@Scope("prototype")
public class Stopwatch {

    private long startedAt;

    @PostConstruct
    public long startedAt() {
        startedAt = System.currentTimeMillis();
        return startedAt;
    }

    public long elapsed() {
        return System.currentTimeMillis() - startedAt;
    }
}
