package com.company.supportsystem.application.usecase.ticket;

import com.company.supportsystem.domain.model.aggregates.Ticket;
import com.company.supportsystem.domain.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTicketUseCaseImpl implements CreateTicketUseCase {

    private final TicketRepository ticketRepository;

    public Ticket execute(String customerId, String createdByUserId, String description) {
        Ticket ticket = new Ticket(customerId, createdByUserId, description);
        return ticketRepository.save(ticket);
    }
}
