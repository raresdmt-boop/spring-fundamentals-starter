package com.example.fundamentals.finala.f05;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = F05BillingEngineTest.TestConfig.class)
@TestPropertySource(properties = "app.billing.tax-percent=10")
class F05BillingEngineTest {

    // Context izolat: scanează DOAR pachetul f05.
    @Configuration
    @ComponentScan
    static class TestConfig {
    }

    @Autowired
    private BillingEngine engine;

    @Test
    void validAmountIsTaxedAndFormattedWithPrimaryFormatter() {
        // Arrange
        int amount = 100;
        String expected = "110 RON";

        // Act
        String actual = engine.invoice(amount);

        // Assert
        assertNotNull(engine);
        assertEquals(expected, actual);
    }

    @Test
    void nonPositiveAmountIsRejected() {
        // Act
        String actual = engine.invoice(-5);

        // Assert
        assertEquals("REJECTED", actual);
    }

    @Test
    void amountOverLimitIsRejected() {
        // Act
        String actual = engine.invoice(2_000_000);

        // Assert
        assertEquals("REJECTED", actual);
    }

    @Test
    void engineSeesAllRulesAfterStartup() {
        // Assert
        assertEquals(2, engine.ruleCount());
    }
}
