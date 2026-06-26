package com.example.debug.d03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TimeoutConfig {

    private final int timeoutSeconds;

    // 🐛 Aici e bug-ul.
    public TimeoutConfig(@Value("${app.timeoutt}") int timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    public int getTimeoutSeconds() {
        return timeoutSeconds;
    }
}
