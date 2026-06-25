package com.example.fundamentals.provocari.c08;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = C08RandomConfigTest.Config.class)
@TestPropertySource(properties = {
        "app.random.seed=42",
        "app.date.pattern=dd/MM/yyyy"
})
class C08RandomConfigTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private Random random;

    @Autowired
    private DateTimeFormatter formatter;

    @Test
    void randomUsesSeedFromProperty() {
        // Arrange
        int expected = new Random(42).nextInt(100);

        // Act
        int actual = random.nextInt(100);

        // Assert
        assertNotNull(random);
        assertEquals(expected, actual);
    }

    @Test
    void formatterUsesPatternFromProperty() {
        // Arrange
        LocalDate date = LocalDate.of(2026, 6, 4);
        String expected = "04/06/2026";

        // Act
        String actual = formatter.format(date);

        // Assert
        assertNotNull(formatter);
        assertEquals(expected, actual);
    }
}
