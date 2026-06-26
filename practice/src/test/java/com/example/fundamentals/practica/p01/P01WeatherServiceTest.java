package com.example.fundamentals.practica.p01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = P01WeatherServiceTest.Config.class)
@TestPropertySource(properties = "app.weather.unit=C")
class P01WeatherServiceTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private WeatherService weatherService;

    @Test
    void currentTemperatureFormatsWithUnitFromYaml() {
        // Arrange
        String expected = "20.0 C";

        // Act
        String actual = weatherService.currentTemperature();

        // Assert
        assertNotNull(weatherService);
        assertEquals(expected, actual);
    }
}
