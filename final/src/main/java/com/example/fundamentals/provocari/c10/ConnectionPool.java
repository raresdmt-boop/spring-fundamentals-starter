package com.example.fundamentals.provocari.c10;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ConnectionPool {

    private int openConnections = 0;

    @PostConstruct
    void openAll() {
        this.openConnections = 10;
    }

    @PreDestroy
    void closeAll() {
        this.openConnections = 0;
    }

    public int getOpenConnections() {
        return openConnections;
    }
}
