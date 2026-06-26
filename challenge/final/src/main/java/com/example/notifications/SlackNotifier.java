package com.example.notifications;

import org.springframework.stereotype.Component;

@Component
public class SlackNotifier implements NotificationChannel {

    @Override
    public String name() {
        return "slack";
    }

    @Override
    public String send(String message) {
        return "SLACK: " + message;
    }
}
