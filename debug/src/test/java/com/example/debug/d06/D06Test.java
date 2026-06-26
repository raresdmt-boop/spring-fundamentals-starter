package com.example.debug.d06;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = D06Application.class)
class D06Test {

    @Autowired
    private ReportingService reportingService;

    @Test
    void reportingServiceUsesDefaultPrefix() {
        // Arrange
        String body = "weekly";

        // Act
        String result = reportingService.report(body);

        // Assert
        assertEquals("LOG: default:weekly", result);
    }
}
