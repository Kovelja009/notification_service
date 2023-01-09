package com.komponente.notification_service.configuration;



import com.komponente.notification_service.dto.NotificationDto;
import com.komponente.notification_service.notifications.NotificationRepo;
import com.komponente.notification_service.notifications.NotificationTypes;
import com.komponente.notification_service.service.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Scheduler {
    private NotificationRepo notificationRepo;
    private EmailService emailService;

    public Scheduler(NotificationRepo notificationRepo, EmailService emailService) {
        this.notificationRepo = notificationRepo;
        this.emailService = emailService;
    }

    @Scheduled(fixedRate = 900_000)
    public void sendReservationReminder(){
        try {

        }catch (Exception e){
            return;
        }
    }

    private boolean checkReminded(){

        return false;
    }
}
