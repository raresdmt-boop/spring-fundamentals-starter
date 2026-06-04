package com.example.fundamentals.practica.p10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class P10StopwatchTest {

    @Autowired
    private Stopwatch stopwatch;

    @Test
    void startedAtIsSetAfterBeanInitialization() {
        // Arrange
        // (Spring a construit bean-ul și a apelat hook-ul de inițializare
        //  înainte ca testul să ruleze)

        // Act
        long started = stopwatch.startedAt();

        // Assert
        assertNotNull(stopwatch);
        assertTrue(started > 0);
    }

    @Test
    void elapsedIsNonNegative() {
        // Arrange
        // (după @PostConstruct, elapsed-ul nu poate fi negativ — timpul curge înainte)

        // Act
        long elapsed = stopwatch.elapsed();

        // Assert
        assertTrue(elapsed >= 0);
    }
}
