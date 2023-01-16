package com.komponente.notification_service.service;


import com.komponente.notification_service.dto.TypeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


public interface TypeService {
    TypeDto addType(TypeDto typeDto);
    Page<TypeDto> findAll(Pageable pageable);
    TypeDto getType(String type);
    void  deleteType(String type);
    String updateType(Long id, String type);
}
