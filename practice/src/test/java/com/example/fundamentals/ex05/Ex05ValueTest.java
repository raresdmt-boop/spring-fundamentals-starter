package com.example.fundamentals.ex05;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Ex05ValueTest.Config.class)
class Ex05ValueTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private AppProperties appProperties;

    @Test
    void greetingComesFromApplicationYaml() {
        // Arrange
        String expected = "Hello from application.yaml";

        // Act
        String actual = appProperties.getGreeting();

        // Assert
        assertNotNull(appProperties);
        assertEquals(expected, actual);
    }
}
