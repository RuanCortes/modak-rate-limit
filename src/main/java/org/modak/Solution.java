package org.modak;

import org.modak.entity.Notification;
import org.modak.entity.Recipient;
import org.modak.entity.enums.Type;
import org.modak.repository.NotificationRepository;
import org.modak.repository.RecipientRepository;
import org.modak.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

@SpringBootApplication
public class Solution implements CommandLineRunner {
    @Autowired
    RecipientRepository recipientRepository;
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    NotificationService notificationService;

    public static void main(String[] args) {
        SpringApplication.run(Solution.class, args);
    }

    @Override
    public void run(String... args){
        Recipient recipient1 = new Recipient();
        recipient1.setEmail("recipient1@testmail.com");
        recipientRepository.save(recipient1);

        Notification notificationNews1 = new Notification();
        notificationNews1.setRecipient(recipient1);
        notificationNews1.setType(Type.NEWS);
        notificationNews1.setMessage("news 1");
        notificationNews1.setDate(Instant.now());
//        notificationRepository.save(notificationNews1);

        Notification notificationNews2 = new Notification();
        notificationNews2.setRecipient(recipient1);
        notificationNews2.setType(Type.NEWS);
        notificationNews2.setMessage("news 2");
        notificationNews2.setDate(Instant.now());
//        notificationRepository.save(notificationNews2);

        Notification notificationNews3 = new Notification();
        notificationNews3.setRecipient(recipient1);
        notificationNews3.setType(Type.NEWS);
        notificationNews3.setMessage("news 3");
        notificationNews3.setDate(Instant.now());
//        notificationRepository.save(notificationNews3);

        Notification notificationMarketing1 = new Notification();
        notificationMarketing1.setRecipient(recipient1);
        notificationMarketing1.setType(Type.MARKETING);
        notificationMarketing1.setMessage("marketing 1");
        notificationMarketing1.setDate(Instant.now());
        notificationRepository.save(notificationMarketing1);

        Notification notificationMarketing2 = new Notification();
        notificationMarketing2.setRecipient(recipient1);
        notificationMarketing2.setType(Type.MARKETING);
        notificationMarketing2.setMessage("marketing 2");
        notificationMarketing2.setDate(Instant.now());
        notificationRepository.save(notificationMarketing2);

        notificationService.send(recipient1, notificationNews1);
    }

}