package com.example.fundamentals.provocari.c07;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = C07ValidationRunnerTest.Config.class)
class C07ValidationRunnerTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private ValidationRunner runner;

    @Test
    void allValidatorsPassWhenInputHasAtAndPlus() {
        // Arrange
        String input = "test@example.com+40";

        // Act
        boolean result = runner.runAll(input);

        // Assert
        assertNotNull(runner);
        assertTrue(result);
    }

    @Test
    void failsWhenAnyValidatorFails() {
        // Arrange
        String missingPlus = "test@example.com";

        // Act
        boolean result = runner.runAll(missingPlus);

        // Assert
        assertFalse(result);
    }
}
