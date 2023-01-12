package com.komponente.notification_service.controllers;

import com.komponente.notification_service.dto.TypeDto;
import com.komponente.notification_service.model.Type;
import com.komponente.notification_service.repositories.TypeRepo;
import com.komponente.notification_service.security.CheckSecurity;
import com.komponente.notification_service.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/types")
public class TypeController {
    private TypeService typeService;
    private TypeRepo typeRepo;
    @PostMapping("/add")
    //@CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<TypeDto> addType(@RequestBody @Valid TypeDto typeDto) {
        return new ResponseEntity<>(typeService.addType(typeDto), HttpStatus.OK);
    }
    @GetMapping("/")
    //@CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<TypeDto> getType(@RequestBody String type) {
        return new ResponseEntity<>(typeService.getType(type), HttpStatus.OK);
    }


    @GetMapping(value = "/get")
    public ResponseEntity<?> getAll(@RequestHeader("Authorization") String authorization){
        try{
                return new ResponseEntity<>(typeRepo.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteOne(@RequestHeader("Authorization") String authorization, @PathVariable Long id){
        try{
            try{
                Type notification = typeRepo.findById(id).get();
                typeRepo.deleteById(notification.getId());
                return new ResponseEntity<>("Successfully deleted notification", HttpStatus.OK);
            }catch (NoSuchElementException e){return new ResponseEntity<>("No such notification",HttpStatus.BAD_REQUEST);}

        }catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
