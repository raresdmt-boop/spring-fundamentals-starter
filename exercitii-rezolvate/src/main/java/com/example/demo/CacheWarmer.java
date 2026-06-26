package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CacheWarmer {

    private final List<String> cache = new ArrayList<>();

    public CacheWarmer() {
        System.out.println("    [@Component] CacheWarmer instantiated (cache e gol)");
    }

    @PostConstruct
    void warmUp() {
        cache.add("alpha");
        cache.add("beta");
        cache.add("gamma");
        System.out.println("    [@PostConstruct] CacheWarmer.warmUp() a rulat → cache = " + cache);
    }

    public List<String> all() {
        return cache;
    }
}
