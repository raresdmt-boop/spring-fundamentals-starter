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
    private Random c08Random;

    @Autowired
    private DateTimeFormatter c08DateFormatter;

    @Test
    void randomUsesSeedFromProperty() {
        // Arrange
        int expected = new Random(42).nextInt(100);

        // Act
        int actual = c08Random.nextInt(100);

        // Assert
        assertNotNull(c08Random);
        assertEquals(expected, actual);
    }

    @Test
    void formatterUsesPatternFromProperty() {
        // Arrange
        LocalDate date = LocalDate.of(2026, 6, 4);
        String expected = "04/06/2026";

        // Act
        String actual = c08DateFormatter.format(date);

        // Assert
        assertNotNull(c08DateFormatter);
        assertEquals(expected, actual);
    }
}
