package com.company.supportsystem.application.usecase.ticket;

import com.company.supportsystem.domain.model.aggregates.Ticket;

public interface StartTicketProgressUseCase {
    Ticket execute(String ticketId);
}
