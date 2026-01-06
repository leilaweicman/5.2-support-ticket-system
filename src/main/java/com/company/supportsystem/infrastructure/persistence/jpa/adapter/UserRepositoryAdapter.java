package com.company.supportsystem.infrastructure.persistence.jpa.adapter;

import com.company.supportsystem.domain.model.aggregates.User;
import com.company.supportsystem.domain.repository.UserRepository;
import com.company.supportsystem.infrastructure.persistence.jpa.entity.UserEntity;
import com.company.supportsystem.infrastructure.persistence.jpa.mapper.UserEntityMapper;
import com.company.supportsystem.infrastructure.persistence.jpa.repository.SpringDataUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository repository;

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username).map(UserEntityMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity saved = repository.save(UserEntityMapper.toEntity(user));
        return UserEntityMapper.toDomain(saved);
    }
}

