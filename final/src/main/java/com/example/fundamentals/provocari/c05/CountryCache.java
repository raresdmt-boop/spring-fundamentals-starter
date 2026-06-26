package com.example.fundamentals.provocari.c05;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CountryCache {

    private final Map<String, String> cache = new HashMap<>();

    @PostConstruct
    void warmUp() {
        cache.put("RO", "Romania");
        cache.put("DE", "Germany");
        cache.put("FR", "France");
    }

    public String get(String code) {
        return cache.get(code);
    }
}
