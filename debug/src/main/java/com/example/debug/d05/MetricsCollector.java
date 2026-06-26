package com.example.debug.d05;

import com.other.d05outside.LegacyMetricsAdapter;
import org.springframework.stereotype.Component;

@Component
public class MetricsCollector {

    private final LegacyMetricsAdapter adapter;

    public MetricsCollector(LegacyMetricsAdapter adapter) {
        this.adapter = adapter;
    }

    public String collect() {
        return adapter.read();
    }
}
