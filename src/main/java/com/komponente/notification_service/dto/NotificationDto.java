package com.komponente.notification_service.dto;

import com.komponente.notification_service.notifications.NotificationTypes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDto {
    private String recipient;
    private String subject;
    private String text;
    private String username;
    private String hotelName;

    public NotificationDto(){

    }

    public NotificationDto(String recipient, String subject, String username, String hotelName) {
        this.recipient = recipient;
        this.subject = subject;
        this.username = username;
        this.hotelName = hotelName;
        this.text = NotificationTypes.getMail(subject, username, hotelName);
    }

}
