package com.example.fundamentals.practica.p03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource(properties = "app.formatter.pattern=dd-MM-yyyy")
class P03DateFormatterTest {

    @Autowired
    private DateTimeFormatter dateFormatter;

    @Test
    void formatterUsesPatternFromYaml() {
        // Arrange
        LocalDate date = LocalDate.of(2026, 6, 3);
        String expected = "03-06-2026";

        // Act
        String actual = dateFormatter.format(date);

        // Assert
        assertNotNull(dateFormatter);
        assertEquals(expected, actual);
    }
}
