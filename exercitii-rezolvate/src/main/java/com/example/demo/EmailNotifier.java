package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailNotifier implements Notifier {

    public EmailNotifier() {
        System.out.println("    [@Component @Primary] EmailNotifier instantiated");
    }

    @Override
    public String send(String message) {
        return "EMAIL: " + message;
    }
}
