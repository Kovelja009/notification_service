package com.komponente.notification_service.controllers;


import com.komponente.notification_service.model.Notification;
import com.komponente.notification_service.repositories.NotificationRepo;
import com.komponente.notification_service.repositories.TypeRepo;
import com.komponente.notification_service.security.CheckSecurity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@SuppressWarnings("all")
@AllArgsConstructor
@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private NotificationRepo notificationRepo;
    private TypeRepo typeRepo;

    @GetMapping
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<?> getAll(@RequestHeader(value = "authorization",required = false) String token){
        try{
               return new ResponseEntity<>(notificationRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/get/{id}")
//    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<?> getOne(@RequestHeader(value = "authorization",required = false) String token, @PathVariable Long id){
        try{
            Notification notification = notificationRepo.findById(id).get();
            return new ResponseEntity<>(notification, HttpStatus.OK);
        }catch (NoSuchElementException e){return new ResponseEntity<>("No such notification",HttpStatus.BAD_REQUEST);}

    }

    @DeleteMapping(value = "/delete/{id}")
//    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<?> deleteOne(@RequestHeader(value = "authorization",required = false) String token, @PathVariable Long id){
        try{
            Notification notification = notificationRepo.findById(id).get();
            notificationRepo.deleteById(notification.getId());
            return new ResponseEntity<>("Successfully deleted notification", HttpStatus.OK);
        }catch (NoSuchElementException e){return new ResponseEntity<>("No such notification",HttpStatus.BAD_REQUEST);}

    }

//    @GetMapping(value = "/users/get")
//    public ResponseEntity<?> getMyNotifications(@RequestHeader(value = "authorization",required = false) String token,
//                                                @RequestHeader(value = "notification-type", required = false) String notificationType){
//
//    }


}
