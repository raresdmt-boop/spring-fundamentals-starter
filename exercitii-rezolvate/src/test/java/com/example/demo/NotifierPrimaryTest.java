package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = NotifierPrimaryTest.Config.class)
class NotifierPrimaryTest {

    @Configuration
    @ComponentScan(excludeFilters = @ComponentScan.Filter(
            type = FilterType.ASSIGNABLE_TYPE, classes = DemoRunner.class))
    static class Config {
    }

    @Autowired
    private Notifier notifier;

    @Test
    void primaryNotifierIsEmail() {
        // Arrange
        String message = "disk full";

        // Act
        String result = notifier.send(message);

        // Assert
        assertTrue(notifier instanceof EmailNotifier);
        assertEquals("EMAIL: disk full", result);
    }
}
