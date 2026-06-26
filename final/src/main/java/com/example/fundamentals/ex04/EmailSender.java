package com.example.fundamentals.ex04;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailSender implements NotificationSender {

    @Override
    public String send(String message) {
        return "EMAIL: " + message;
    }
}
