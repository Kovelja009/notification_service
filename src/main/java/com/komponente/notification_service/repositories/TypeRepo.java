package com.komponente.notification_service.repositories;

import com.komponente.notification_service.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepo extends JpaRepository<Type, Long> {
    Optional<Type> findByType(String type);
}
