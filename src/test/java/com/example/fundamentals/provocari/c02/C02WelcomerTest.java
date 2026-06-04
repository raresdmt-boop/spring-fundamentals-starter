package com.example.fundamentals.provocari.c02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class C02WelcomerTest {

    @Autowired
    private Welcomer welcomer;

    @Test
    void welcomeUsesEnglishByDefault() {
        // Arrange
        String expected = "Hello, Rares!";

        // Act
        String actual = welcomer.welcome("Rares");

        // Assert
        assertNotNull(welcomer);
        assertEquals(expected, actual);
    }
}
