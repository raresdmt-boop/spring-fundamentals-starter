package com.example.fundamentals.finala.f02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = F02DiscountResolverTest.TestConfig.class)
class F02DiscountResolverTest {

    // Context izolat: scanează DOAR pachetul f02.
    @Configuration
    @ComponentScan
    static class TestConfig {
    }

    @Autowired
    private DiscountResolver resolver;

    @Test
    void appliesNamedDiscount() {
        // Arrange
        int price = 100;

        // Act
        int half = resolver.finalPrice("half", price);
        int tenoff = resolver.finalPrice("tenoff", price);

        // Assert
        assertNotNull(resolver);
        assertEquals(50, half);
        assertEquals(90, tenoff);
    }

    @Test
    void unknownCodeUsesFallback() {
        // Arrange
        int price = 100;

        // Act
        int actual = resolver.finalPrice("does-not-exist", price);

        // Assert
        assertEquals(100, actual);
    }
}
