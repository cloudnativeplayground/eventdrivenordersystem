package com.cloudnativeplayground.notificationservice.service;

import com.cloudnativeplayground.notificationservice.model.Notification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    private final List<Notification> notifications = new ArrayList<>();

    public void sendNotification(String message) {
        Notification notification = new Notification();
        notification.setId(String.valueOf(notifications.size() + 1));
        notification.setMessage(message);
        notifications.add(notification);

        // Simulating sending the notification
        System.out.println("Notification sent: " + message);
    }

    public List<Notification> getAllNotifications() {
        return notifications;
    }
}
