package com.example.notifications;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

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

        if(message!=null) {
            String msgChannel = message.split(" ")[0];
            String msgChannelName = msgChannel.split(":")[0];

            if (spamFilter.isSpam(message)) {
                return "BLOCKED: spam detected";
            }

            for(NotificationChannel channel : channels) {
                if(channel.name().equalsIgnoreCase(msgChannelName)) {
                    Objects.requireNonNull(auditLogProvider.getIfAvailable()).record(channel.send(message));
                    return channel.send(message);
                }
                if (msgChannelName.equalsIgnoreCase(channel.name())) {
                    Objects.requireNonNull(auditLogProvider.getIfAvailable()).record(channel.send(message));
                    return channel.send(message);
                }
            }
        }
        return message;
    }
}
