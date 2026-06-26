package com.example.debug.d06;

import org.springframework.stereotype.Component;

@Component
public class LoggerService {

    public String log(String msg) {
        return "LOG: " + msg;
    }
}
