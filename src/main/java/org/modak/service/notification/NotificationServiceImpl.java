package org.modak.service.notification;

import org.modak.entity.Notification;
import org.modak.entity.Recipient;
import org.modak.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modak.repository.RecipientRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class NotificationServiceImpl implements NotificationService {
    private Gateway gateway;

    private NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(Gateway gateway, NotificationRepository notificationRepository) {
        this.gateway = gateway;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void send(Recipient recipient, Notification notification) {
        if(calculateRateLimit(recipient, notification)){
            gateway.send(recipient.getEmail(), notification.getMessage());
        } else{
            System.out.println("number of " + notification.getType() + " notifications exceeded for recipient: " + recipient.getEmail());
        }
    }

    private boolean calculateRateLimit(Recipient recipient, Notification notification){
        Instant limitPeriodRange = Instant.now().minus(notification.getType().getDuration());

        int numberNotificationsSent = notificationRepository.countByRecipientAndTypeAndDateAfter(recipient, notification.getType(), limitPeriodRange);

        if (numberNotificationsSent < notification.getType().getLimit())
            return true;
        return false;
    }

}