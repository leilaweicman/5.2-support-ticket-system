package com.company.supportsystem.application.usecase.ticket;

import com.company.supportsystem.domain.exception.TicketNotFoundException;
import com.company.supportsystem.domain.model.aggregates.Ticket;
import com.company.supportsystem.domain.model.valueobjects.TicketId;
import com.company.supportsystem.domain.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignTicketUseCaseImpl implements AssignTicketUseCase {

    private final TicketRepository ticketRepository;

    @Override
    public void execute(String ticketId, String technicianUserId) {
        Ticket ticket = ticketRepository.findById(TicketId.from(ticketId))
                .orElseThrow(() -> new TicketNotFoundException(ticketId));

        ticket.assignTo(technicianUserId);
        ticketRepository.save(ticket);
    }
}

