package org.modak.service.notification;

import org.springframework.stereotype.Service;

@Service
public class Gateway {

    /* already implemented */
    void send(String email, String message) {
        System.out.println("sending message to user " + email);
    }

}