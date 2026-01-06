package com.company.supportsystem.infrastructure.persistence.jpa.repository;

import com.company.supportsystem.infrastructure.persistence.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataUserRepository
        extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByUsername(String username);
}

