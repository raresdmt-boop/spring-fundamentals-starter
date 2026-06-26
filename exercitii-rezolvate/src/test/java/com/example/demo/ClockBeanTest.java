package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.time.Clock;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest(classes = ClockBeanTest.Config.class)
class ClockBeanTest {

    @Configuration
    @ComponentScan(excludeFilters = @ComponentScan.Filter(
            type = FilterType.ASSIGNABLE_TYPE, classes = DemoRunner.class))
    static class Config {
    }

    @Autowired
    private Clock first;

    @Autowired
    private Clock second;

    @Test
    void clockBeanUsesBucharestZoneAndIsSingleton() {
        // Arrange
        ZoneId expectedZone = ZoneId.of("Europe/Bucharest");

        // Act
        ZoneId actualZone = first.getZone();

        // Assert
        assertEquals(expectedZone, actualZone);
        assertSame(first, second);
    }
}
