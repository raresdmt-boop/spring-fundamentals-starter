package com.example.fundamentals.provocari.c03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource(properties = "app.vat.rate=0.19")
class C03VatCalculatorTest {

    @Autowired
    private VatCalculator vatCalculator;

    @Test
    void calculateVatFor100() {
        // Arrange
        double amount = 100.0;
        double expected = 19.0;

        // Act
        double actual = vatCalculator.calculate(amount);

        // Assert
        assertNotNull(vatCalculator);
        assertEquals(expected, actual, 0.0001);
    }
}
