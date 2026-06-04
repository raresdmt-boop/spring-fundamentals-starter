package com.example.fundamentals.ex01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class Ex01GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    void greetingServiceIsManagedAsBean() {
        // Arrange
        // (Spring a încărcat contextul; @Autowired ne-a livrat bean-ul)

        // Act
        GreetingService injected = greetingService;

        // Assert
        assertNotNull(injected);
    }

    @Test
    void greetReturnsPersonalizedMessage() {
        // Arrange
        String name = "Ana";

        // Act
        String result = greetingService.greet(name);

        // Assert
        assertEquals("Hello, Ana!", result);
    }
}
