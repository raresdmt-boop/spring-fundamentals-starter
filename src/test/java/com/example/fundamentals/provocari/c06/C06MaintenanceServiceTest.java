package com.example.fundamentals.provocari.c06;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("ops")
class C06MaintenanceServiceTest {

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
