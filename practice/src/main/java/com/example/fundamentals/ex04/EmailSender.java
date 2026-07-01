package com.example.fundamentals.ex04;

import org.springframework.stereotype.Component;

// TODO: Marchează clasa cu @Component("email").
// Numele explicit "email" îl vom referi în Alerts prin @Qualifier.
@Component("email1")
public class EmailSender implements NotificationSender {

    @Override
    public String send(String message) {
        return "EMAIL: " + message;
    }
}
