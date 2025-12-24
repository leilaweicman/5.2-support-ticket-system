package com.company.supportsystem.application.usecase.ticket;

import com.company.supportsystem.domain.model.aggregates.Ticket;

public interface CreateTicketUseCase {
    Ticket execute(String customerId, String createdByUserId, String description);
}
