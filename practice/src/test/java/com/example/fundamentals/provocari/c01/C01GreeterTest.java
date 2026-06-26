package com.example.fundamentals.provocari.c01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = C01GreeterTest.Config.class)
class C01GreeterTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private Greeter greeter;

    @Test
    void greetsByName() {
        // Arrange
        String expected = "Salut, Rares!";

        // Act
        String actual = greeter.greet("Rares");

        // Assert
        assertNotNull(greeter);
        assertEquals(expected, actual);
    }
}
