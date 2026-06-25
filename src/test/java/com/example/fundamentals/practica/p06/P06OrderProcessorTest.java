package com.example.fundamentals.practica.p06;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.fundamentals.ex03.ClockConfig;
import com.example.fundamentals.practica.p01.WeatherService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = P06OrderProcessorTest.Config.class)
class P06OrderProcessorTest {

    @Configuration
    @ComponentScan(basePackageClasses = {OrderProcessor.class, ClockConfig.class, WeatherService.class})
    static class Config {
    }

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
