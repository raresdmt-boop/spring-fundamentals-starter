package com.example.debug.d03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = D03Application.class)
class D03Test {

    @Autowired
    private TimeoutConfig timeoutConfig;

    @Test
    void timeoutComesFromYaml() {
        // Arrange
        int expected = 30;

        // Act
        int actual = timeoutConfig.getTimeoutSeconds();

        // Assert
        assertEquals(expected, actual);
    }
}
