package com.example.debug.d07;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = D07Application.class)
class D07Test {

    @Autowired
    private ApiClient apiClient;

    @Test
    void apiClientHasConfiguredBaseUrl() {
        // Arrange
        String expected = "https://api.example.com";

        // Act
        String actual = apiClient.getBaseUrl();

        // Assert
        assertEquals(expected, actual);
    }
}
