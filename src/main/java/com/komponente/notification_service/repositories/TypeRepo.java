package com.komponente.notification_service.repositories;

import com.komponente.notification_service.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends JpaRepository<Type, Long> {
    Type findByType(String type);
}
