package com.example.fundamentals.practica.p05;

// Cerință:
// RequestCounter trebuie să fie un bean Spring cu scope "prototype" — adică
// Spring să creeze o INSTANȚĂ NOUĂ la fiecare cerere/injecție (nu singleton).
// increment() crește un contor intern; current() întoarce valoarea curentă.
//
// Hint: @Scope e tratat în TEORIE.md, secțiunea `@Scope("prototype") (P05)`.

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RequestCounter {

    private int count = 0;

    public void increment() {
        count++;
    }

    public int current() {
        return count;
    }
}
