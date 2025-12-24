package com.company.supportsystem.domain.model.state;

import com.company.supportsystem.domain.model.aggregates.Ticket;

public interface TicketState {
    void rehydrate(Ticket ticket, String solution);
}
