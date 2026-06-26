package com.example.fundamentals.provocari.c10;

import com.example.fundamentals.FundamentalsApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class C10ConnectionPoolTest {

    @Test
    void poolIsOpenAtStartupAndClosedAtShutdown() {
        // Arrange
        ConfigurableApplicationContext context = SpringApplication.run(FundamentalsApplication.class);
        ConnectionPool pool = context.getBean(ConnectionPool.class);

        // Act
        int afterStartup = pool.getOpenConnections();
        context.close();
        int afterShutdown = pool.getOpenConnections();

        // Assert
        assertNotNull(pool);
        assertEquals(10, afterStartup);
        assertEquals(0, afterShutdown);
    }
}
