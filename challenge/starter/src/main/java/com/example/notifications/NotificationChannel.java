package com.example.notifications;

public interface NotificationChannel {

    String name();

    String send(String message);
}
