package com.company.supportsystem.domain.model.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

public record TicketId(String value) {

    public static TicketId generate() {
        return new TicketId(UUID.randomUUID().toString());
    }

    public static TicketId from(String value) {
        return new TicketId(value);
    }
}

