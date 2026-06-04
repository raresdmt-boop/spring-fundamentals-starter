package com.example.fundamentals.provocari.c05;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class C05CountryCacheTest {

    @Autowired
    private CountryCache countryCache;

    @Test
    void cacheIsPrePopulatedAtStartup() {
        // Arrange
        // (nimic — cache-ul ar trebui sa fie deja populat la pornire)

        // Act
        String ro = countryCache.get("RO");
        String de = countryCache.get("DE");
        String fr = countryCache.get("FR");

        // Assert
        assertNotNull(countryCache);
        assertEquals("Romania", ro);
        assertEquals("Germany", de);
        assertEquals("France", fr);
    }
}
