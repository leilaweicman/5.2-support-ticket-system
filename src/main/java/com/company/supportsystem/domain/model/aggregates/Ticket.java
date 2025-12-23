package com.company.supportsystem.domain.model.aggregates;

import com.company.supportsystem.domain.exception.InvalidTicketStateException;
import com.company.supportsystem.domain.model.valueobjects.TicketId;
import com.company.supportsystem.domain.model.valueobjects.TicketStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = "id")
public class Ticket {

    private final TicketId id;
    private final String customerId;
    private final String createdByUserId;

    private String assignedToUserId;
    private final String description;
    private String solution;

    private TicketStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime closedAt;

    public Ticket(String customerId, String createdByUserId, String description) {
        this.id = new TicketId();
        this.customerId = customerId;
        this.createdByUserId = createdByUserId;
        this.description = description;
        this.status = TicketStatus.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public void assignTo(String technicianUserId) {
        if (status != TicketStatus.CREATED) {
            throw new InvalidTicketStateException(
                    "Ticket can only be assigned when in CREATED state"
            );
        }
        this.assignedToUserId = technicianUserId;
        this.status = TicketStatus.ASSIGNED;
    }

    public void startProgress() {
        if (status != TicketStatus.ASSIGNED) {
            throw new InvalidTicketStateException(
                    "Ticket can only start progress when ASSIGNED"
            );
        }
        this.status = TicketStatus.IN_PROGRESS;
    }

    public void resolve(String solution) {
        if (status != TicketStatus.IN_PROGRESS) {
            throw new InvalidTicketStateException(
                    "Ticket can only be resolved when IN_PROGRESS"
            );
        }
        this.solution = solution;
        this.status = TicketStatus.RESOLVED;
    }

    public void close() {
        if (status != TicketStatus.RESOLVED) {
            throw new InvalidTicketStateException(
                    "Ticket can only be closed when RESOLVED"
            );
        }
        this.status = TicketStatus.CLOSED;
        this.closedAt = LocalDateTime.now();
    }

}
