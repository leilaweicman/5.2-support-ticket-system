package com.company.supportsystem.application.usecase.ticket;

import com.company.supportsystem.domain.model.aggregates.Ticket;
import com.company.supportsystem.domain.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllTicketsUseCaseImpl implements GetAllTicketsUseCase {

    private final TicketRepository ticketRepository;

    @Override
    public List<Ticket> execute() {
        return ticketRepository.findAll();
    }
}

