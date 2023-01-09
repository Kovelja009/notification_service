package com.komponente.notification_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
public class Param {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean firstName;
    private Boolean lastName;

    private Boolean company;
    private Boolean username;
    private Boolean model;

    private Boolean link;


}
