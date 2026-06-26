package com.example.fundamentals.ex04;

// TODO: Marchează clasa cu @Component("email").
// Numele explicit "email" îl vom referi în Alerts prin @Qualifier.

public class EmailSender implements NotificationSender {

    @Override
    public String send(String message) {
        return "EMAIL: " + message;
    }
}
