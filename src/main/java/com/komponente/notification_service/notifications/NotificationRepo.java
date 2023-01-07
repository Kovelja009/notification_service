package com.komponente.notification_service.notifications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface NotificationRepo extends JpaRepository<Notification, Long> {
    List<Notification> findByType(String type);
    List<Notification> findByRecipient(String recipient);
    List<Notification> findByRecipientAndType(String recipient, String type);
}

