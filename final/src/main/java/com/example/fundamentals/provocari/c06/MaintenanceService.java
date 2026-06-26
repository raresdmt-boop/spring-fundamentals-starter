package com.example.fundamentals.provocari.c06;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("ops")
public class MaintenanceService {

    public String run() {
        return "DONE";
    }
}
