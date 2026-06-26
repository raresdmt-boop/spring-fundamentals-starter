package com.example.notifications;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.ApplicationContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = AuditLogInactiveProfileTest.Config.class)
class AuditLogInactiveProfileTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private NotificationService notificationService;

    @Test
    void auditLogIsNotInContextWithoutAuditProfile() {
        // Arrange
        // (profilul "audit" NU e activ în acest test)

        // Act
        Map<String, AuditLog> auditBeans = applicationContext.getBeansOfType(AuditLog.class);

        // Assert
        assertTrue(auditBeans.isEmpty());
    }

    @Test
    void notificationStillWorksWithoutAuditLog() {
        // Arrange
        String message = "no audit here";

        // Act
        String result = notificationService.notify(message);

        // Assert
        assertEquals("EMAIL: no audit here", result);
    }
}
