package com.example.notifications;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final Map<String, NotificationChannel> channelsByName;
    private final String defaultChannel;
    private final SpamFilter spamFilter;
    private final ObjectProvider<AuditLog> auditLogProvider;

    public NotificationService(List<NotificationChannel> channels,
                               @Value("${app.notifications.default-channel}") String defaultChannel,
                               SpamFilter spamFilter,
                               ObjectProvider<AuditLog> auditLogProvider) {
        this.channelsByName = channels.stream()
                .collect(Collectors.toMap(NotificationChannel::name, c -> c));
        this.defaultChannel = defaultChannel;
        this.spamFilter = spamFilter;
        this.auditLogProvider = auditLogProvider;
    }

    public String notify(String message) {
        if (spamFilter.isSpam(message)) {
            return "BLOCKED: spam detected";
        }

        NotificationChannel channel = channelsByName.get(defaultChannel);
        if (channel == null) {
            throw new IllegalStateException(
                    "Unknown default channel: " + defaultChannel + ". Available: " + channelsByName.keySet());
        }

        String result = channel.send(message);

        AuditLog audit = auditLogProvider.getIfAvailable();
        if (audit != null) {
            audit.record(result);
        }

        return result;
    }
}
