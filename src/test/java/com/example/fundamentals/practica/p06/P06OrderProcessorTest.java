package com.example.fundamentals.practica.p06;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class P06OrderProcessorTest {

    @Autowired
    private OrderProcessor orderProcessor;

    @Test
    void summaryCombinesClockAndWeather() {
        // Arrange
        String expected = "Order on Europe/Bucharest | Temp: 20.0 C";

        // Act
        String actual = orderProcessor.summary();

        // Assert
        assertNotNull(orderProcessor);
        assertEquals(expected, actual);
    }
}
