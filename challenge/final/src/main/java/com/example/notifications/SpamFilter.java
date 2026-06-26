package com.example.notifications;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Component
public class SpamFilter {

    private final Set<String> blacklist = new HashSet<>();

    @PostConstruct
    void loadBlacklist() {
        blacklist.add("lottery");
        blacklist.add("winner");
        blacklist.add("prize");
    }

    public boolean isSpam(String message) {
        String lower = message.toLowerCase(Locale.ROOT);
        return blacklist.stream().anyMatch(lower::contains);
    }
}
