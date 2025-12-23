package com.company.supportsystem.domain.repository;

import com.company.supportsystem.domain.model.aggregates.Ticket;
import com.company.supportsystem.domain.model.valueobjects.TicketId;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {

    Ticket save(Ticket ticket);

    Optional<Ticket> findById(TicketId id);

    List<Ticket> findAllActive();

    List<Ticket> findClosedByCustomerId(String customerId);
}
