package com.komponente.notification_service.listener;

import com.komponente.notification_service.dto.NotificationDto;
import com.komponente.notification_service.listener.helper.MessageHelper;
import com.komponente.notification_service.mapper.ObjectMapper;
import com.komponente.notification_service.model.Notification;
import com.komponente.notification_service.model.Param;
import com.komponente.notification_service.repositories.NotificationRepo;
import com.komponente.notification_service.repositories.ParamsRepo;
import com.komponente.notification_service.service.EmailService;
import javax.jms.JMSException;
import javax.jms.Message;

import com.komponente.notification_service.service.ParamService;
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
    private ParamsRepo paramsRepo;
    private ParamService paramService;



    @JmsListener(destination = "${destination.activationMail}", concurrency = "5-10")
    public void saveNotification(Message message) throws JMSException {
        System.out.println("EmailListener: saveNotification"+message);
        sendMail(messageHelper.getMessage(message, NotificationDto.class));

    }

    @JmsListener(destination = "${destination.reservationMail}", concurrency = "5-10")
    public void reservationConfirmation(Message message) throws JMSException{
        System.out.println("EmailListener: saveNotification"+message);
        sendMail(messageHelper.getMessage(message, NotificationDto.class));
    }

    @JmsListener(destination = "${destination.cancelledMail}", concurrency = "5-10")
    public void reservationCancelled(Message message) throws JMSException{
        System.out.println("EmailListener: saveNotification"+message);
        sendMail(messageHelper.getMessage(message, NotificationDto.class));
    }

    @JmsListener(destination = "${destination.passwordMail}", concurrency = "5-10")
    public void passwordChange(Message message) throws JMSException{
        System.out.println("EmailListener: saveNotification"+message);
        sendMail(messageHelper.getMessage(message, NotificationDto.class));
    }

    public void sendMail(NotificationDto notificationDto){
        Notification notification = objectMapper.notificationFromNotificationDto(notificationDto);

        Param param= notification.getParam();
        if(paramService.findByParam(param)==null)
            paramsRepo.save(param);
        else
            notification.setParam(paramService.findByParam(param));
        System.out.println(notification.getText());
        try{
            emailService.sendSimpleMessage(notification.getRecipient(), notification.getType().getType(), notification.getText());
        }catch (Exception e){
            System.out.println(notification.getRecipient());
            System.out.println(notification.getType().getType());
            System.out.println( notification.getText());
        }
        notificationRepo.save(notification);
    }
}
