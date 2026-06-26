package com.example.fundamentals.provocari.c02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = C02LangWelcomerTest.Config.class)
class C02LangWelcomerTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private LangWelcomer welcomer;

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
