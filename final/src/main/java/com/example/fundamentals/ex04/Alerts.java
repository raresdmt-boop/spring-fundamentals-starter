package com.example.fundamentals.ex04;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alerts {

    private final NotificationSender sender;

    public Alerts(@Qualifier("email") NotificationSender sender) {
        this.sender = sender;
    }

    public String raise(String alert) {
        return sender.send(alert);
    }
}
