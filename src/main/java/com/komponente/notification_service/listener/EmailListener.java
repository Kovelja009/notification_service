package com.komponente.notification_service.listener;



import com.komponente.notification_service.dto.NotificationDto;
import com.komponente.notification_service.listener.helper.MessageHelper;
import com.komponente.notification_service.notifications.Notification;
import com.komponente.notification_service.notifications.NotificationRepo;
import com.komponente.notification_service.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;



@Component
public class EmailListener {

    @Autowired
    private NotificationRepo notificationRepo;
    private final MessageHelper messageHelper;

    private final EmailService emailService;

    public EmailListener(MessageHelper messageHelper, EmailService emailService) {
        this.messageHelper = messageHelper;
        this.emailService = emailService;
    }

    @JmsListener(destination = "account-activation", concurrency = "5-10")
    public void saveNotification(Message message) throws JMSException{
        NotificationDto notificationDto = messageHelper.getMessage(message, NotificationDto.class);
        emailService.sendSimpleMessage(notificationDto.getRecipient(), notificationDto.getSubject(), notificationDto.getText());
        Notification notification = new Notification(notificationDto.getRecipient(), notificationDto.getSubject());
        notificationRepo.save(notification);
    }

    @JmsListener(destination = "reservation-confirmation", concurrency = "5-10")
    public void reservationConfirmation(Message message) throws JMSException{
        NotificationDto notificationDto = messageHelper.getMessage(message, NotificationDto.class);
        emailService.sendSimpleMessage(notificationDto.getRecipient(), notificationDto.getSubject(), notificationDto.getText());
        Notification notification = new Notification(notificationDto.getRecipient(), notificationDto.getSubject());
        notificationRepo.save(notification);
    }

    @JmsListener(destination = "reservation-cancelled", concurrency = "5-10")
    public void reservationCancelled(Message message) throws JMSException{
        NotificationDto notificationDto = messageHelper.getMessage(message, NotificationDto.class);
        emailService.sendSimpleMessage(notificationDto.getRecipient(), notificationDto.getSubject(), notificationDto.getText());
        Notification notification = new Notification(notificationDto.getRecipient(), notificationDto.getSubject());
        notificationRepo.save(notification);
    }

    @JmsListener(destination = "password-change", concurrency = "5-10")
    public void passwordChange(Message message) throws JMSException{
        NotificationDto notificationDto = messageHelper.getMessage(message, NotificationDto.class);
        emailService.sendSimpleMessage(notificationDto.getRecipient(), notificationDto.getSubject(), notificationDto.getText());
        Notification notification = new Notification(notificationDto.getRecipient(), notificationDto.getSubject());
        notificationRepo.save(notification);
    }
}
