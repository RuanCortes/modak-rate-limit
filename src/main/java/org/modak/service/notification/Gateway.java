package org.modak.service.notification;

import org.springframework.stereotype.Service;

@Service
public class Gateway {

    void send(String email, String message) {
        System.out.println("Sending message to user " + email);
    }

}