package com.cloudnativeplayground.notificationservice.controller;

import com.cloudnativeplayground.notificationservice.model.Notification;
import com.cloudnativeplayground.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/status")
    public String getStatus() {
        return "Notification Service is up and running!";
    }

    @PostMapping
    public String sendNotification(@RequestBody Notification notification) {
        notificationService.sendNotification(notification.getMessage());
        return "Notification sent: " + notification.getMessage();
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
}
