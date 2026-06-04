package com.example.fundamentals.ex03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Clock;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
class Ex03ClockBeanTest {

    @Autowired
    private Clock first;

    @Autowired
    private Clock second;

    @Test
    void clockBeanUsesBucharestTimezone() {
        // Arrange
        ZoneId expected = ZoneId.of("Europe/Bucharest");

        // Act
        ZoneId actual = first.getZone();

        // Assert
        assertNotNull(first);
        assertEquals(expected, actual);
    }

    @Test
    void clockBeanIsSingleton() {
        // Arrange
        // (Spring injectează același Clock în ambele câmpuri pentru că scope-ul
        //  implicit al bean-urilor e singleton.)

        // Act
        Clock a = first;
        Clock b = second;

        // Assert
        assertSame(a, b);
    }
}
