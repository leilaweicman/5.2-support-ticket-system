package com.company.supportsystem.infrastructure.persistence.jpa.mapper;

import com.company.supportsystem.domain.model.aggregates.Ticket;
import com.company.supportsystem.domain.model.state.TicketState;
import com.company.supportsystem.domain.model.valueobjects.TicketStatus;
import com.company.supportsystem.infrastructure.persistence.jpa.entity.TicketEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TicketEntityMapper {

    public static TicketEntity toEntity(Ticket ticket) {
        TicketEntity entity = new TicketEntity();

        entity.setId(ticket.getId().getValue());
        entity.setCustomerId(ticket.getCustomerId());
        entity.setCreatedByUserId(ticket.getCreatedByUserId());
        entity.setAssignedToUserId(ticket.getAssignedToUserId());
        entity.setDescription(ticket.getDescription());
        entity.setSolution(ticket.getSolution());
        entity.setStatus(ticket.getStatus().name());
        entity.setCreatedAt(ticket.getCreatedAt());
        entity.setClosedAt(ticket.getClosedAt());

        return entity;
    }

    public static Ticket toDomain(TicketEntity entity) {
        Ticket ticket = new Ticket(
                entity.getCustomerId(),
                entity.getCreatedByUserId(),
                entity.getDescription()
        );

        if (entity.getAssignedToUserId() != null) {
            ticket.assignTo(entity.getAssignedToUserId());
        }

        TicketStatus status = TicketStatus.valueOf(entity.getStatus());

        status.state().rehydrate(ticket, entity.getSolution());

        return ticket;
    }

}
