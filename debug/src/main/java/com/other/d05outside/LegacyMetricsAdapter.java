package com.other.d05outside;

import org.springframework.stereotype.Component;

@Component
public class LegacyMetricsAdapter {

    public String read() {
        return "metrics:ok";
    }
}
