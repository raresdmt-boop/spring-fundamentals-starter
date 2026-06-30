package com.example.fundamentals.ex02;

import org.springframework.stereotype.Service;

// TODO: Marchează clasa cu @Service.
// @Service e o specializare semantică a @Component pentru clase care conțin
// logică de business. Funcțional, pentru container e identic cu @Component —
// dar exprimă intenția mai clar pentru cititor.
@Service
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
}
