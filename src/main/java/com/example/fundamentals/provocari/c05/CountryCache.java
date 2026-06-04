package com.example.fundamentals.provocari.c05;

import java.util.HashMap;
import java.util.Map;

public class CountryCache {

    private final Map<String, String> cache = new HashMap<>();

    public String get(String code) {
        return cache.get(code);
    }
}
