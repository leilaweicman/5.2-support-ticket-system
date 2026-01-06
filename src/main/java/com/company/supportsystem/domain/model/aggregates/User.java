package com.company.supportsystem.domain.model.aggregates;

import com.company.supportsystem.domain.model.valueobjects.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode(of = "id")
@RequiredArgsConstructor
public class User {
    private final String id;
    private final String username;
    private final String passwordHash;
    private final Role role;
}

