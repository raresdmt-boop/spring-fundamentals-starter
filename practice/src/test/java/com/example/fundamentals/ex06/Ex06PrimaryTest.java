package com.example.fundamentals.ex06;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Ex06PrimaryTest.Config.class)
class Ex06PrimaryTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private Checkout checkout;

    @Test
    void checkoutUsesStripeBecauseItIsPrimary() {
        // Arrange
        int amountCents = 1999;

        // Act
        String result = checkout.pay(amountCents);

        // Assert
        assertNotNull(checkout);
        assertEquals("STRIPE charged 1999 cents", result);
    }
}
