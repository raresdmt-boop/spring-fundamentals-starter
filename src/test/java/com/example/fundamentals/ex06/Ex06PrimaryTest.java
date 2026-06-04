package com.example.fundamentals.ex06;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class Ex06PrimaryTest {

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
