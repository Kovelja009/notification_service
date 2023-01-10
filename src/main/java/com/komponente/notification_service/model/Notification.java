package com.komponente.notification_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    private Type type;
    @ManyToOne(optional = false)
    private Param param;
    private String recipient;
    private String text;
    private Instant createdAt = Instant.now();
    private Instant lastModified;

    public Notification() {
    }

    public Notification(Type type, Param param, String recipient, String text) {
        this.type = type;
        this.param = param;
        this.recipient = recipient;
        this.text = getMessage(text,param);
    }
    public void setText(String text) {
        this.text = getMessage(text,param);
    }

    private String getMessage(String text, Param param){
        List<Object> params = new ArrayList<>();
        if(param.getFirstName()!=null) params.add(param.getFirstName());
        if(param.getLastName()!=null) params.add(param.getLastName());
        if(param.getCompany()!=null) params.add(param.getCompany());
        if(param.getUsername()!=null) params.add(param.getUsername());
        if(param.getModel()!=null) params.add(param.getModel());
        if(param.getLink()!=null) params.add(param.getLink());
        return String.format(text,params.toArray());
    }
}
