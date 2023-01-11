package com.komponente.notification_service.repositories;

import com.komponente.notification_service.model.Param;
import com.komponente.notification_service.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParamsRepo extends JpaRepository<Param, Long> {
    /*
    private String firstName;
    private String lastName;
    private String company;
    private String username;
    private String model;
    private String link;
     */
    Optional<Param> findByFirstNameAndLastNameAndCompanyAndUsernameAndModelAndLink(String firstName,String lastName, String company,String username, String model, String link);
}
