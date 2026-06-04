package com.example.fundamentals.practica.p08;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class P08InventoryServiceTest {

    @Autowired
    private InventoryService inventoryService;

    @Test
    void countMatchesCatalogSize() {
        // Arrange
        int expectedSize = 3;

        // Act
        int actualSize = inventoryService.count();

        // Assert
        assertNotNull(inventoryService);
        assertEquals(expectedSize, actualSize);
    }
}
