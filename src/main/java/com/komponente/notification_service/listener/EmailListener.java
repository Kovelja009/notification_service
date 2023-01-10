package com.komponente.notification_service.listener;

import com.komponente.notification_service.dto.NotificationDto;
import com.komponente.notification_service.listener.helper.MessageHelper;
import com.komponente.notification_service.mapper.ObjectMapper;
import com.komponente.notification_service.model.Notification;
import com.komponente.notification_service.repositories.NotificationRepo;
import com.komponente.notification_service.service.EmailService;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;



@AllArgsConstructor
@Component
public class EmailListener {
    private NotificationRepo notificationRepo;
    private ObjectMapper objectMapper;
    private final MessageHelper messageHelper;
    private final EmailService emailService;



    @JmsListener(destination = "${destination.activationMail}", concurrency = "5-10")
    public void saveNotification(Message message) throws JMSException {
        NotificationDto notificationDto = messageHelper.getMessage(message, NotificationDto.class);
        Notification notification = objectMapper.notificationFromNotificationDto(notificationDto);
        emailService.sendSimpleMessage(notification.getRecipient(), notification.getType().getType(), notification.getText());
        notificationRepo.save(notification);
    }

    @JmsListener(destination = "${destination.reservationMail}", concurrency = "5-10")
    public void reservationConfirmation(Message message) throws JMSException{
        NotificationDto notificationDto = messageHelper.getMessage(message, NotificationDto.class);
        Notification notification = objectMapper.notificationFromNotificationDto(notificationDto);
        emailService.sendSimpleMessage(notification.getRecipient(), notification.getType().getType(), notification.getText());
        notificationRepo.save(notification);
    }

    @JmsListener(destination = "${destination.cancelledMail}", concurrency = "5-10")
    public void reservationCancelled(Message message) throws JMSException{
        NotificationDto notificationDto = messageHelper.getMessage(message, NotificationDto.class);
        Notification notification = objectMapper.notificationFromNotificationDto(notificationDto);
        emailService.sendSimpleMessage(notification.getRecipient(), notification.getType().getType(), notification.getText());
        notificationRepo.save(notification);
    }

    @JmsListener(destination = "${destination.passwordMail}", concurrency = "5-10")
    public void passwordChange(Message message) throws JMSException{
        NotificationDto notificationDto = messageHelper.getMessage(message, NotificationDto.class);
        Notification notification = objectMapper.notificationFromNotificationDto(notificationDto);
        emailService.sendSimpleMessage(notification.getRecipient(), notification.getType().getType(), notification.getText());
        notificationRepo.save(notification);
    }
}
