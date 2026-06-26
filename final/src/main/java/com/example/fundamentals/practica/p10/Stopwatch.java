package com.example.fundamentals.practica.p10;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Stopwatch {

    private long startedAt;

    @PostConstruct
    void start() {
        this.startedAt = System.currentTimeMillis();
    }

    public long startedAt() {
        return startedAt;
    }

    public long elapsed() {
        return System.currentTimeMillis() - startedAt;
    }
}
