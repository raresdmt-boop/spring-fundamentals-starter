package com.example.fundamentals.finala.f01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = F01MiddlewareChainTest.TestConfig.class)
class F01MiddlewareChainTest {

    // Context izolat: scanează DOAR pachetul f01, deci alte exerciții (rezolvate
    // sau nu) nu pot strica acest test.
    @Configuration
    @ComponentScan
    static class TestConfig {
    }

    @Autowired
    private MiddlewareChain chain;

    @Test
    void middlewaresRunInDeclaredOrder() {
        // Arrange
        String expected = "REQ[auth][log][zip]";

        // Act
        String actual = chain.process("REQ");

        // Assert
        assertNotNull(chain);
        assertEquals(expected, actual);
    }

    @Test
    void chainKnowsItsSizeAfterStartup() {
        // Arrange
        int expected = 3;

        // Act
        int actual = chain.size();

        // Assert
        assertEquals(expected, actual);
    }
}
