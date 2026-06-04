package com.example.fundamentals.practica.p09;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class P09UserRegistrationServiceTest {

    @Autowired
    private UserRegistrationService registrationService;

    @Test
    void canRegisterWhenAllValidatorsPass() {
        // Arrange
        String username = "ana";
        String password = "secret12";

        // Act
        boolean allowed = registrationService.canRegister(username, password);

        // Assert
        assertNotNull(registrationService);
        assertTrue(allowed);
    }

    @Test
    void cannotRegisterWhenUsernameTooShort() {
        // Arrange
        String username = "an";
        String password = "secret12";

        // Act
        boolean allowed = registrationService.canRegister(username, password);

        // Assert
        assertFalse(allowed);
    }

    @Test
    void cannotRegisterWhenPasswordTooShort() {
        // Arrange
        String username = "ana";
        String password = "short";

        // Act
        boolean allowed = registrationService.canRegister(username, password);

        // Assert
        assertFalse(allowed);
    }
}
