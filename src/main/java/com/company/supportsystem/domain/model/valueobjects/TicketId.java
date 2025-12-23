package com.company.supportsystem.domain.model.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
@EqualsAndHashCode
public class TicketId {

    private final String value;

    public TicketId() {
        this.value = UUID.randomUUID().toString();
    }

    public TicketId(String value) {
        this.value = value;
    }
}

