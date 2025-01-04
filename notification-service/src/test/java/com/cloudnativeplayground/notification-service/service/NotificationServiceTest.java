package com.cloudnativeplayground.notificationservice.service;

import org.junit.jupiter.api.Test;

public class NotificationServiceTest {

    @Test
    public void testSendNotification() {
        NotificationService service = new NotificationService();
        service.sendNotification("Test message");
    }
}