package com.komponente.notification_service.repositories;

import com.komponente.notification_service.model.Notification;
import com.komponente.notification_service.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {
    List<Notification> findByType(Type type);
    List<Notification> findByRecipient(String recipient);
    List<Notification> findByRecipientAndType(String recipient, Type type);
}

