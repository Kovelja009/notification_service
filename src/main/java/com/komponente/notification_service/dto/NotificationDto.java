package com.komponente.notification_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDto {
    private String recipient;
    private String subject;
    private String text;
    private String firstName;
    private String lastName;

    private String company;
    private String username;
    private String model;
    private String link;
}
