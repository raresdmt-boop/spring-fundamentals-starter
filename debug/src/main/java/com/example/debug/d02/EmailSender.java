package com.example.debug.d02;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    private final EmailFormatter formatter;

    // 🐛 Aici e bug-ul.
    public EmailSender(EmailFormatter formatter) {
        this.formatter = formatter;
    }

    public String send(String body) {
        return "Sent: " + formatter.format(body);
    }
}
