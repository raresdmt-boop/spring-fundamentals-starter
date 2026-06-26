package com.example.fundamentals.ex04;

import org.springframework.stereotype.Component;

@Component("sms")
public class SmsSender implements NotificationSender {

    @Override
    public String send(String message) {
        return "SMS: " + message;
    }
}
