package com.example.fundamentals.finala.f04;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = F04ExportServiceEnterpriseTest.TestConfig.class)
@ActiveProfiles("enterprise")
class F04ExportServiceEnterpriseTest {

    // Context izolat: scanează DOAR pachetul f04.
    @Configuration
    @ComponentScan
    static class TestConfig {
    }

    @Autowired
    private ExportService service;

    @Test
    void xmlExporterIsActiveOnEnterpriseProfile() {
        // Assert
        assertNotNull(service);
        assertTrue(service.supports("xml"));
        assertEquals(3, service.formatCount());
    }

    @Test
    void runsXmlExporter() {
        // Act
        String actual = service.run("xml", "x");

        // Assert
        assertEquals("<x>", actual);
    }
}
