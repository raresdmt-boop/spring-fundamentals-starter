package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = CacheWarmerTest.Config.class)
class CacheWarmerTest {

    @Configuration
    @ComponentScan(excludeFilters = @ComponentScan.Filter(
            type = FilterType.ASSIGNABLE_TYPE, classes = DemoRunner.class))
    static class Config {
    }

    @Autowired
    private CacheWarmer cacheWarmer;

    @Test
    void cacheIsPopulatedByPostConstruct() {
        // Arrange
        List<String> expected = List.of("alpha", "beta", "gamma");

        // Act
        List<String> actual = cacheWarmer.all();

        // Assert
        assertEquals(expected, actual);
    }
}
