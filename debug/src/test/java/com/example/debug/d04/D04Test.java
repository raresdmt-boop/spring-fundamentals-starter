package com.example.debug.d04;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = D04Application.class)
class D04Test {

    @Autowired
    private ServiceA serviceA;

    @Test
    void serviceAUsesServiceB() {
        // Arrange
        String expected = "A:B";

        // Act
        String result = serviceA.workA();

        // Assert
        assertEquals(expected, result);
    }
}
