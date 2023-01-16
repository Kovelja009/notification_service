package com.komponente.notification_service.listener;

import com.komponente.notification_service.dto.NotificationDto;
import com.komponente.notification_service.dto.ReservationDto;
import com.komponente.notification_service.mapper.ObjectMapper;
import com.komponente.notification_service.model.Notification;
import com.komponente.notification_service.repositories.NotificationRepo;
import com.komponente.notification_service.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class Scheduler {
    private NotificationRepo notificationRepo;
    private EmailListener emailListener;
    private RestTemplate reservationServiceRestTemplate;
    private ObjectMapper objectMapper;

//    ResponseEntity<UserDto> userDto =  userServiceRestTemplate.exchange("/user/id?id="+reviewCreateDto.getUserId().toString(), HttpMethod.GET, null, UserDto.class);

    @Scheduled(fixedRate = 90)
    public void sendReservationReminder(){
        try {

            ResponseEntity<List<NotificationDto>> notificationsDto =  reservationServiceRestTemplate.exchange("http://localhost:8081/api/reservation/remind", HttpMethod.GET, null, new ParameterizedTypeReference<List<NotificationDto>>() {});
            System.out.println(notificationsDto.getBody());
            List<NotificationDto> notificationDtos = notificationsDto.getBody();

            if(notificationDtos==null)
                return;
            for(NotificationDto not:notificationDtos){
                emailListener.sendMail(not);
            }

//            List<Notification> notifications = notificationsDto.getBody().stream().map(objectMapper::notificationFromNotificationDto).collect(Collectors.toList());
//            for(Notification notification:notifications){
//                emailService.sendSimpleMessage(notification.getRecipient(), notification.getType().getType(), notification.getText());
//                notificationRepo.save(notification);
//            }
        }catch (Exception e){
            return;
        }
    }
}
