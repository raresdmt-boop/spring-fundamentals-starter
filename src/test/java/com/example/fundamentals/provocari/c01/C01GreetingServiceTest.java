package com.example.fundamentals.provocari.c01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = C01GreetingServiceTest.Config.class)
class C01GreetingServiceTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private GreetingService greetingService;

    @Test
    void greetsByName() {
        // Arrange
        String expected = "Salut, Rares!";

        // Act
        String actual = greetingService.greet("Rares");

        // Assert
        assertNotNull(greetingService);
        assertEquals(expected, actual);
    }
}
