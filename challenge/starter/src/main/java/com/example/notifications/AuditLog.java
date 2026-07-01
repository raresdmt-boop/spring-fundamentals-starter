package com.example.notifications;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("audit")
public class AuditLog {


    private final List<String> entries= new ArrayList<>();

    public void record(String message) {
        entries.add(message);
    }

    public List<String> entries() {
        return entries;
    }
}
