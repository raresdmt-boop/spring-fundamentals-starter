package com.example.fundamentals.provocari.c10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = C10ConnectionPoolTest.Config.class)
class C10ConnectionPoolTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private ConnectionPool pool;

    @Autowired
    private ConfigurableApplicationContext context;

    @Test
    void poolIsOpenAfterStartup() {
        // Arrange
        int expected = 10;

        // Act
        int actual = pool.getOpenConnections();

        // Assert
        assertNotNull(pool);
        assertEquals(expected, actual);
    }

    @Test
    void poolIsClosedAfterShutdown() {
        // Arrange
        int expected = 0;

        // Act
        context.close();
        int actual = pool.getOpenConnections();

        // Assert
        assertEquals(expected, actual);
    }
}
