package com.example.fundamentals.provocari.c01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class C01GreetingServiceTest {

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
