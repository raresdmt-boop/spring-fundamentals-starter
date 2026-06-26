package com.example.debug.d06;

import org.springframework.stereotype.Component;

@Component
public class ReportingService {

    private final LoggerService logger;
    private final String prefix;

    // 🐛 Aici e bug-ul.
    public ReportingService(LoggerService logger) {
        this.logger = logger;
        this.prefix = "default";
    }

    public ReportingService(LoggerService logger, String prefix) {
        this.logger = logger;
        this.prefix = prefix;
    }

    public String report(String body) {
        return logger.log(prefix + ":" + body);
    }
}
