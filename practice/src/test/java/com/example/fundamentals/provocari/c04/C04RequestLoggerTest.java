package com.example.fundamentals.provocari.c04;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

@SpringBootTest(classes = C04RequestLoggerTest.Config.class)
class C04RequestLoggerTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private ApplicationContext context;

    @Test
    void requestLoggerIsFreshOnEachLookup() {
        // Arrange
        RequestLogger first = context.getBean(RequestLogger.class);
        RequestLogger second = context.getBean(RequestLogger.class);

        // Act
        first.setRequestId("REQ-1");

        // Assert
        assertNotNull(first);
        assertNotNull(second);
        assertNotSame(first, second);
    }
}
