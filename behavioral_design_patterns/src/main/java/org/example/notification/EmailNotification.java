package org.example.notification;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Email Notification: " + message);
    }
}
