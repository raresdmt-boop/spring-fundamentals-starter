package com.example.notifications;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = AuditLogActiveProfileTest.Config.class)
@ActiveProfiles("audit")
class AuditLogActiveProfileTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private AuditLog auditLog;

    @Test
    void auditLogRecordsSuccessfulNotifications() {
        // Arrange
        notificationService.notify("first");
        notificationService.notify("second");
        notificationService.notify("you won a prize!");

        // Act
        List<String> entries = auditLog.entries();

        // Assert
        assertEquals(2, entries.size());
        assertTrue(entries.contains("EMAIL: first"));
        assertTrue(entries.contains("EMAIL: second"));
    }
}
