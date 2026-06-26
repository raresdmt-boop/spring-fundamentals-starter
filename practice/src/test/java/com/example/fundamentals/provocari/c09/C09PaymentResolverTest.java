package com.example.fundamentals.provocari.c09;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = C09PaymentResolverTest.Config.class)
class C09PaymentResolverTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private PaymentResolver resolver;

    @Test
    void resolvesCardStrategy() {
        // Arrange
        String key = "card";
        String expected = "CARD: 200";

        // Act
        String actual = resolver.resolve(key).pay(200);

        // Assert
        assertNotNull(resolver);
        assertEquals(expected, actual);
    }

    @Test
    void resolvesPaypalStrategy() {
        // Arrange
        String key = "paypal";
        String expected = "PAYPAL: 50";

        // Act
        String actual = resolver.resolve(key).pay(50);

        // Assert
        assertEquals(expected, actual);
    }
}
