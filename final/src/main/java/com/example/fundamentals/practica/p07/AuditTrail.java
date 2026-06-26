package com.example.fundamentals.practica.p07;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("audit")
public class AuditTrail {

    public String log(String event) {
        return "AUDIT: " + event;
    }
}
