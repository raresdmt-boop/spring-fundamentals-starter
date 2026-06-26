package com.example.fundamentals.practica.p04;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class EmailSanitizer {

    private final Set<String> blacklist = new HashSet<>();

    @PostConstruct
    void loadBlacklist() {
        blacklist.add("gmail.com");
        blacklist.add("yahoo.com");
    }

    public boolean isAllowed(String email) {
        int atIndex = email.indexOf('@');
        String domain = email.substring(atIndex + 1);
        return !blacklist.contains(domain);
    }
}
