package com.example.debug.d02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = D02Application.class)
class D02Test {

    @Autowired
    private EmailSender emailSender;

    @Test
    void emailSenderUsesHtmlFormatter() {
        // Arrange
        String body = "hello";

        // Act
        String result = emailSender.send(body);

        // Assert
        assertEquals("Sent: <p>hello</p>", result);
    }
}
