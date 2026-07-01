package com.example.notifications;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationService {

    private final List<NotificationChannel> channels;

    private String defaultChannel;
    private final SpamFilter spamFilter;
    private final ObjectProvider<AuditLog> auditLogProvider;


    public NotificationService(List<NotificationChannel> channels,
                               @Value("${app.notifications.default-channel}")
                               String defaultChannel,
                               SpamFilter spamFilter,
                               ObjectProvider<AuditLog> auditLogProvider) {
        this.channels = channels;
        this.defaultChannel = defaultChannel;
        this.spamFilter = spamFilter;
        this.auditLogProvider = auditLogProvider;
    }

    public String notify(String message) {

        if (message != null) {
            String msgChannel = message.split(" ")[0];
            String msgChannelName = msgChannel.split(":")[0];

            if (spamFilter.isSpam(message)) {
                return "BLOCKED: spam detected";
            }

            for (NotificationChannel channel : channels) {
                if (channel.name().equalsIgnoreCase(msgChannelName)) {
                    return dispatch(channel, message);
                }
            }

            for (NotificationChannel channel : channels) {
                if (channel.name().equalsIgnoreCase(defaultChannel)) {
                    return dispatch(channel, message);
                }
            }
        }
        return message;
    }

    private String dispatch(NotificationChannel channel, String message) {
        String result = channel.send(message);
        auditLogProvider.ifAvailable(log -> log.record(result));
        return result;
    }
}
