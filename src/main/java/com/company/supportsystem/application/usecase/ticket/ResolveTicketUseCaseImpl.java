package com.company.supportsystem.application.usecase.ticket;

import com.company.supportsystem.domain.exception.TicketNotFoundException;
import com.company.supportsystem.domain.model.aggregates.Ticket;
import com.company.supportsystem.domain.model.valueobjects.TicketId;
import com.company.supportsystem.domain.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResolveTicketUseCaseImpl implements ResolveTicketUseCase {

    private final TicketRepository ticketRepository;

    @Override
    public Ticket execute(String ticketId, String solution) {
        Ticket ticket = ticketRepository.findById(TicketId.from(ticketId))
                .orElseThrow(() -> new TicketNotFoundException(ticketId));

        ticket.resolve(solution);
        return ticketRepository.save(ticket);
    }
}

