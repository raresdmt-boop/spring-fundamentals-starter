package com.example.notifications;

import org.springframework.stereotype.Component;

@Component
public class SmsNotifier implements NotificationChannel {

    @Override
    public String name() {
        return "sms";
    }

    @Override
    public String send(String message) {
        return "SMS: " + message;
    }
}
