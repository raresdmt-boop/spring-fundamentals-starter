package com.example.notifications;

import org.springframework.stereotype.Component;

@Component
public class EmailNotifier implements NotificationChannel {

    @Override
    public String name() {
        return "email";
    }

    @Override
    public String send(String message) {
        return "EMAIL: " + message;
    }
}
