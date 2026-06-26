package com.example.fundamentals.practica.p02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = P02WelcomerTest.Config.class)
class P02WelcomerTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private Welcomer welcomer;

    @Test
    void welcomerUsesEnglishByDefault() {
        // Arrange
        String name = "Ana";

        // Act
        String result = welcomer.welcome(name);

        // Assert
        assertNotNull(welcomer);
        assertEquals("Hello, Ana!", result);
    }
}
