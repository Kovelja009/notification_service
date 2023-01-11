package com.komponente.notification_service.mapper;

import com.komponente.notification_service.dto.NotificationDto;
import com.komponente.notification_service.dto.TypeDto;
import com.komponente.notification_service.model.Notification;
import com.komponente.notification_service.model.Param;
import com.komponente.notification_service.model.Type;
import com.komponente.notification_service.repositories.TypeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
@AllArgsConstructor
@Component
public class ObjectMapper {
    private TypeRepo typeRepo;

    public Param paramFromNotificationDto(NotificationDto dto){
        Param param =  new Param();
        param.setCompany(dto.getCompany());
        param.setLink(dto.getLink());
        param.setModel(dto.getModel());
        param.setUsername(dto.getUsername());
        param.setFirstName(dto.getFirstName());
        param.setLastName(dto.getLastName());
        return param;
    }

    public Notification notificationFromNotificationDto(NotificationDto dto){
        return new Notification(typeRepo.findByType(dto.getSubject()).get(),paramFromNotificationDto(dto),dto.getRecipient(),dto.getText());
    }
    public TypeDto typeToTypeDto(Type type){ return new TypeDto(type.getType());}
    public Type typeDtoToType(TypeDto dto){
        Type type = new Type();
        type.setType(dto.getType());
        return type;
    }


}
