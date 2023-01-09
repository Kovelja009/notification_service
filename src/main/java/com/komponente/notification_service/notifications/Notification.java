package com.komponente.notification_service.notifications;


import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipient;
    private String type;
    private Instant createdAt = Instant.now();
    private Instant lastModified;

    public Notification(String recipient, String type) {
        this.recipient = recipient;
        this.type = type;
    }

    public Notification() {}

}
