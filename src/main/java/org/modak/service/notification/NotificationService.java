package org.modak.service.notification;

import org.modak.entity.Notification;
import org.modak.entity.Recipient;

public interface NotificationService {
    void send(Recipient recipient, Notification notification);
}