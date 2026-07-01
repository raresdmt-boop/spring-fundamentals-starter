package com.example.fundamentals.ex04;

import org.springframework.stereotype.Component;

// TODO: Marchează clasa cu @Component("sms").
@Component("sms1")
public class SmsSender implements NotificationSender {

    @Override
    public String send(String message) {
        return "SMS: " + message;
    }
}
