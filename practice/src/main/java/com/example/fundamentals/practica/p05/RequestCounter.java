package com.example.fundamentals.practica.p05;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Cerință:
// RequestCounter trebuie să fie un bean Spring cu scope "prototype" — adică
// Spring să creeze o INSTANȚĂ NOUĂ la fiecare cerere/injecție (nu singleton).
// increment() crește un contor intern; current() întoarce valoarea curentă.
//
// Hint: @Scope e tratat în THEORY.md, secțiunea 7.3.
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
