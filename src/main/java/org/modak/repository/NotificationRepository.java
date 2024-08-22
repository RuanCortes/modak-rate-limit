package org.modak.repository;

import org.modak.entity.Notification;
import org.modak.entity.Recipient;
import org.modak.entity.enums.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, UUID> {
    int countByRecipientAndTypeAndDateAfter(Recipient recipient, Type type, Instant instant);

}
