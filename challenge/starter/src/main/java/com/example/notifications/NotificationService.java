package com.example.notifications;

import org.springframework.beans.factory.ObjectProvider;

import java.util.List;

public class NotificationService {

    public NotificationService(List<NotificationChannel> channels,
                               String defaultChannel,
                               SpamFilter spamFilter,
                               ObjectProvider<AuditLog> auditLogProvider) {
    }

    public String notify(String message) {
        throw new UnsupportedOperationException("TODO");
    }
}
