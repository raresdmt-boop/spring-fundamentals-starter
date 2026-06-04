package com.example.fundamentals.practica.p05;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

@SpringBootTest
class P05RequestCounterTest {

    @Autowired
    private RequestCounter first;

    @Autowired
    private RequestCounter second;

    @Test
    void prototypeScopeGivesDifferentInstances() {
        // Arrange
        // (Spring injectează două INSTANȚE diferite pentru că bean-ul e prototype)

        // Act
        RequestCounter a = first;
        RequestCounter b = second;

        // Assert
        assertNotSame(a, b);
    }

    @Test
    void incrementingOneDoesNotAffectOther() {
        // Arrange
        first.increment();
        first.increment();
        first.increment();

        // Act
        int firstCount = first.current();
        int secondCount = second.current();

        // Assert
        assertEquals(3, firstCount);
        assertEquals(0, secondCount);
    }
}
