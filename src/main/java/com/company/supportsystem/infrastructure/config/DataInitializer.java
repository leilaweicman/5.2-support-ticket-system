package com.company.supportsystem.infrastructure.config;

import com.company.supportsystem.domain.model.aggregates.User;
import com.company.supportsystem.domain.model.valueobjects.Role;
import com.company.supportsystem.domain.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {

        userRepository.save(
                new User(
                        UUID.randomUUID().toString(),
                        "admin",
                        passwordEncoder.encode("admin123"),
                        Role.ADMIN
                )
        );

        userRepository.save(
                new User(
                        UUID.randomUUID().toString(),
                        "tech1",
                        passwordEncoder.encode("tech123"),
                        Role.TECH
                )
        );
    }
}

