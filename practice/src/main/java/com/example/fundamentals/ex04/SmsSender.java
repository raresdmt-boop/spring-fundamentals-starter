package com.example.fundamentals.ex04;

// TODO: Marchează clasa cu @Component("sms").

public class SmsSender implements NotificationSender {

    @Override
    public String send(String message) {
        return "SMS: " + message;
    }
}
