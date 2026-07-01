package com.example.notifications;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotifier implements NotificationChannel {

    @Override
    public String name() {
        return "email";
    }

    @Override
    public String send(String message) {
        return "EMAIL: " +message;
    }
}
