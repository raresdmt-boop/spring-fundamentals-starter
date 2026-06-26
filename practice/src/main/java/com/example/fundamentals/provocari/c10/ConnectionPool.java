package com.example.fundamentals.provocari.c10;

public class ConnectionPool {

    private int openConnections = 0;

    public int getOpenConnections() {
        return openConnections;
    }

    protected void setOpenConnections(int value) {
        this.openConnections = value;
    }
}
