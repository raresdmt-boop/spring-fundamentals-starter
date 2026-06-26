package com.example.fundamentals.ex07;

import java.util.ArrayList;
import java.util.List;

// TODO:
//   1. Marchează clasa cu @Component.
//   2. Adaugă o metodă privată `void warmUp()` adnotată cu @PostConstruct.
//      În corpul ei, pune trei valori în `cache`: "alpha", "beta", "gamma".
//      → @PostConstruct rulează automat după ce Spring a construit bean-ul și
//        a injectat dependențele. Locul natural pentru: pre-încărcare cache,
//        validări la pornire, conexiuni externe.
//
// Importă jakarta.annotation.PostConstruct (NU javax.annotation.* — vechi).

public class CacheWarmer {

    private final List<String> cache = new ArrayList<>();

    public List<String> all() {
        return cache;
    }
}
