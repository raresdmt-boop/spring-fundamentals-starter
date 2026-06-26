package com.example.fundamentals.provocari.c06;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = C06MaintenanceServiceTest.Config.class)
@ActiveProfiles("ops")
class C06MaintenanceServiceTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private MaintenanceService maintenanceService;

    @Test
    void maintenanceServiceRunsWhenOpsProfileActive() {
        // Arrange
        String expected = "DONE";

        // Act
        String actual = maintenanceService.run();

        // Assert
        assertNotNull(maintenanceService);
        assertEquals(expected, actual);
    }
}
