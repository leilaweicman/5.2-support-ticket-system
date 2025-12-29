package com.company.supportsystem.application.usecase.ticket;

import com.company.supportsystem.domain.model.aggregates.Ticket;

import java.util.List;

public interface GetAllTicketsUseCase {
    List<Ticket> execute();
}
