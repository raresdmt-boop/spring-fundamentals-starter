package com.example.fundamentals.ex04;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Ex04QualifierTest.Config.class)
class Ex04QualifierTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private Alerts alerts;

    @Test
    void alertsUsesEmailSender() {
        // Arrange
        String message = "disk full";

        // Act
        String result = alerts.raise(message);

        // Assert
        assertNotNull(alerts);
        assertEquals("EMAIL: disk full", result);
    }
}
