package com.example.fundamentals.finala.f03;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class F03MetricsBufferTest {

    @Test
    void bufferRespectsLifecycleAndCapacity() {
        // Arrange — pornim un container Spring de sine stătător, ca să-i putem
        // controla explicit pornirea și oprirea (pentru @PostConstruct / @PreDestroy).
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PropertySourcesPlaceholderConfigurer.class);
        context.scan("com.example.fundamentals.finala.f03");
        context.refresh();

        MetricsBuffer buffer = context.getBean(MetricsBuffer.class);

        // Assert — bean-ul e gata după pornire (@PostConstruct a rulat)
        assertNotNull(buffer);
        assertTrue(buffer.isReady());

        // capacitatea (default 3) e respectată
        buffer.record(1);
        buffer.record(2);
        buffer.record(3);
        buffer.record(4);
        assertEquals(3, buffer.count());

        // oprirea contextului declanșează @PreDestroy
        context.close();
        assertTrue(buffer.isFlushed());
        assertEquals(0, buffer.count());
    }
}
