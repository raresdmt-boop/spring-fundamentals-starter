package com.example.debug.d05;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = D05Application.class)
class D05Test {

    @Autowired
    private MetricsCollector metricsCollector;

    @Test
    void metricsCollectorReadsFromLegacyAdapter() {
        // Arrange
        String expected = "metrics:ok";

        // Act
        String result = metricsCollector.collect();

        // Assert
        assertEquals(expected, result);
    }
}
