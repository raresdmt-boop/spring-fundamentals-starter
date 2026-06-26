package com.example.debug.d01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = D01Application.class)
class D01Test {

    @Autowired
    private GreetingClient greetingClient;

    @Test
    void greetingClientCanBeInjected() {
        // Arrange
        String name = "Ana";

        // Act
        String result = greetingClient.send(name);

        // Assert
        assertEquals("Hello, Ana!", result);
    }
}
