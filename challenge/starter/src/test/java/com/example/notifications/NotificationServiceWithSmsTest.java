package com.example.notifications;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = NotificationServiceWithSmsTest.Config.class)
@TestPropertySource(properties = "app.notifications.default-channel=sms")
class NotificationServiceWithSmsTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private NotificationService notificationService;

    @Test
    void notifiesViaSmsWhenDefaultChannelIsSms() {
        // Arrange
        String message = "your code is 1234";

        // Act
        String result = notificationService.notify(message);

        // Assert
        assertEquals("SMS: your code is 1234", result);
    }
}
