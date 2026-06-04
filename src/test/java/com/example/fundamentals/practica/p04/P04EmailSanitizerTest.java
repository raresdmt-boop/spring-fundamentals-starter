package com.example.fundamentals.practica.p04;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class P04EmailSanitizerTest {

    @Autowired
    private EmailSanitizer sanitizer;

    @Test
    void gmailIsBlocked() {
        // Arrange
        String email = "ana@gmail.com";

        // Act
        boolean allowed = sanitizer.isAllowed(email);

        // Assert
        assertNotNull(sanitizer);
        assertFalse(allowed);
    }

    @Test
    void yahooIsBlocked() {
        // Arrange
        String email = "vlad@yahoo.com";

        // Act
        boolean allowed = sanitizer.isAllowed(email);

        // Assert
        assertFalse(allowed);
    }

    @Test
    void customDomainIsAllowed() {
        // Arrange
        String email = "ana@example.com";

        // Act
        boolean allowed = sanitizer.isAllowed(email);

        // Assert
        assertTrue(allowed);
    }
}
