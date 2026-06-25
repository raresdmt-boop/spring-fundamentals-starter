package com.example.fundamentals.finala.f04;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = F04ExportServiceTest.TestConfig.class)
class F04ExportServiceTest {

    // Context izolat: scanează DOAR pachetul f04.
    @Configuration
    @ComponentScan
    static class TestConfig {
    }

    @Autowired
    private ExportService service;

    @Test
    void defaultExportersAreAvailable() {
        // Assert
        assertNotNull(service);
        assertTrue(service.supports("json"));
        assertTrue(service.supports("csv"));
        assertEquals(2, service.formatCount());
    }

    @Test
    void xmlIsAbsentWithoutEnterpriseProfile() {
        // Assert
        assertFalse(service.supports("xml"));
    }

    @Test
    void runsTheRequestedExporter() {
        // Act
        String actual = service.run("json", "x");

        // Assert
        assertEquals("{x}", actual);
    }
}
