package com.company.supportsystem.infrastructure.persistence.jpa.mapper;

import com.company.supportsystem.domain.model.aggregates.User;
import com.company.supportsystem.infrastructure.persistence.jpa.entity.UserEntity;

public class UserEntityMapper {

    public static User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getUsername(),
                entity.getPasswordHash(),
                entity.getRole()
        );
    }

    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setPasswordHash(user.getPasswordHash());
        entity.setRole(user.getRole());
        return entity;
    }
}

