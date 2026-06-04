package com.example.fundamentals.ex04;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class Ex04QualifierTest {

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
