package com.example.fundamentals.ex07;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Ex07PostConstructTest.Config.class)
class Ex07PostConstructTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private CacheWarmer cacheWarmer;

    @Test
    void cacheIsPopulatedAfterPostConstruct() {
        // Arrange
        // (Spring a apelat metoda @PostConstruct înainte ca testul să ruleze)

        // Act
        List<String> cache = cacheWarmer.all();

        // Assert
        assertNotNull(cacheWarmer);
        assertEquals(3, cache.size());
        assertTrue(cache.contains("alpha"));
        assertTrue(cache.contains("beta"));
        assertTrue(cache.contains("gamma"));
    }
}
