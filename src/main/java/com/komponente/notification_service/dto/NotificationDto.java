package com.komponente.notification_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "NotificationDto{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", username='" + username + '\'' +
                ", model='" + model + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
