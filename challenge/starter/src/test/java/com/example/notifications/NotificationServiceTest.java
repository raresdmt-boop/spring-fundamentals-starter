package com.example.notifications;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = NotificationServiceTest.Config.class)
@TestPropertySource(properties = "app.notifications.default-channel=email")
class NotificationServiceTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private NotificationService notificationService;

    @Test
    void notifiesViaEmailWhenDefaultChannelIsEmail() {
        // Arrange
        String message = "team meeting at 3pm";

        // Act
        String result = notificationService.notify(message);

        // Assert
        assertNotNull(notificationService);
        assertEquals("EMAIL: team meeting at 3pm", result);
    }

    @Test
    void blocksMessagesContainingBlacklistedWord() {
        // Arrange
        String message = "You are the winner of our lottery!";

        // Act
        String result = notificationService.notify(message);

        // Assert
        assertEquals("BLOCKED: spam detected", result);
    }
}
