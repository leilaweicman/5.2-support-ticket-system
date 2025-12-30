package com.company.supportsystem.infrastructure.persistence.jpa.entity;

import com.company.supportsystem.domain.model.valueobjects.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
public class TicketEntity {

    @Id
    private String id;

    private String customerId;
    private String createdByUserId;
    private String assignedToUserId;

    private String description;
    private String solution;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime closedAt;
}

