package com.komponente.notification_service.notifications;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
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
}
