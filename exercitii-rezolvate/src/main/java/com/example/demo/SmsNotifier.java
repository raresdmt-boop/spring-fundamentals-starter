package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SmsNotifier implements Notifier {

    public SmsNotifier() {
        System.out.println("    [@Component] SmsNotifier instantiated (NU e @Primary)");
    }

    @Override
    public String send(String message) {
        return "SMS: " + message;
    }
}
