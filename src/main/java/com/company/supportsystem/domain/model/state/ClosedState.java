package com.company.supportsystem.domain.model.state;

import com.company.supportsystem.domain.model.aggregates.Ticket;

public class ClosedState implements TicketState {

    @Override
    public void rehydrate(Ticket ticket, String solution) {
        ticket.startProgress();
        ticket.resolve(solution);
        ticket.close();
    }
}