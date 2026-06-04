package com.example.fundamentals.practica.p07;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("audit")
class P07AuditTrailTest {

    @Autowired
    private AuditTrail auditTrail;

    @Test
    void auditTrailLogsEventOnAuditProfile() {
        // Arrange
        String event = "user.login";

        // Act
        String result = auditTrail.log(event);

        // Assert
        assertNotNull(auditTrail);
        assertEquals("AUDIT: user.login", result);
    }
}
