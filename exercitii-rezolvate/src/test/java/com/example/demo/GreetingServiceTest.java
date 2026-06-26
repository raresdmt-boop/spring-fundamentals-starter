package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = GreetingServiceTest.Config.class)
class GreetingServiceTest {

    @Configuration
    @ComponentScan(excludeFilters = @ComponentScan.Filter(
            type = FilterType.ASSIGNABLE_TYPE, classes = DemoRunner.class))
    static class Config {
    }

    @Autowired
    private GreetingService greetingService;

    @Test
    void greetUsesPrefixFromYaml() {
        // Arrange
        String name = "Ana";

        // Act
        String result = greetingService.greet(name);

        // Assert
        assertNotNull(greetingService);
        assertEquals("Hello from yaml — Ana", result);
    }
}
