package com.company.supportsystem.domain.repository;

import com.company.supportsystem.domain.model.aggregates.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);

    User save(User user);
}

