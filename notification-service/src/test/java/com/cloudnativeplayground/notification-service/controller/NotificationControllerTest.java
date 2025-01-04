package com.cloudnativeplayground.notificationservice.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationControllerTest {

    @Test
    public void testGetStatus() {
        NotificationController controller = new NotificationController();
        String status = controller.getStatus();
        assertEquals("Notification Service is up and running!", status);
    }
}