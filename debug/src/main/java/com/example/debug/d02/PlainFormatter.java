package com.example.debug.d02;

import org.springframework.stereotype.Component;

@Component
public class PlainFormatter implements EmailFormatter {

    @Override
    public String format(String body) {
        return body;
    }
}
