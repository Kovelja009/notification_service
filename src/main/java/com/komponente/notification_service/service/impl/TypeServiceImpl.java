package com.komponente.notification_service.service.impl;

import com.komponente.notification_service.dto.TypeDto;
import com.komponente.notification_service.exceptions.NotFoundException;
import com.komponente.notification_service.mapper.ObjectMapper;
import com.komponente.notification_service.model.Type;
import com.komponente.notification_service.repositories.TypeRepo;
import com.komponente.notification_service.service.TypeService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TypeServiceImpl implements TypeService {
    private ObjectMapper objectMapper;
    private TypeRepo typeRepo;

    @Override
    public TypeDto addType(TypeDto typDto) {
        Optional<Type> typeOptional = typeRepo.findByType(typDto.getType());
        if(typeOptional.isPresent())
            throw new IllegalArgumentException("Type " + typDto.getType() + " already exists");
        Type type = objectMapper.typeDtoToType(typDto);
        typeRepo.save(type);
        return typDto;
    }

    @Override
    public Page<TypeDto> findAll(Pageable pageable) {
        return typeRepo.findAll(pageable).map(objectMapper::typeToTypeDto);

    }
    @Override
    public TypeDto getType(String type) {
        Optional<Type> user = typeRepo.findByType(type);
        return new TypeDto(user.get().getType());
    }

    @Override
    public void deleteType(String typee) {
        Optional<Type> type = typeRepo.findByType(typee);
        type.ifPresent(value -> typeRepo.deleteById(value.getId()));

    }

    @Override
    public String updateType(Long id, String typeNew) {
        Type type = typeRepo.findById(id).get();
        type.setType(typeNew);
        typeRepo.save(type);
        return typeNew;
    }


}
