package com.example.fundamentals.provocari.c10;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ConnectionPool {

    @PostConstruct
    public void init() {
        setOpenConnections(10);
    }

    private int openConnections = 0;

    public int getOpenConnections() {
        return openConnections;
    }


    protected void setOpenConnections(int value) {
        this.openConnections = value;
    }

    @PreDestroy
    public void closeConnections() {
        setOpenConnections(0);
    }

}
