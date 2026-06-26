package com.example.fundamentals.ex07;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CacheWarmer {

    private final List<String> cache = new ArrayList<>();

    @PostConstruct
    void warmUp() {
        cache.add("alpha");
        cache.add("beta");
        cache.add("gamma");
    }

    public List<String> all() {
        return cache;
    }
}
