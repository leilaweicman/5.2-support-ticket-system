package com.company.supportsystem.infrastructure.web.controller;

import com.company.supportsystem.application.usecase.ticket.GetAllTicketsUseCaseImpl;
import com.company.supportsystem.infrastructure.web.dto.CreateTicketRequest;
import com.company.supportsystem.application.usecase.ticket.CreateTicketUseCaseImpl;
import com.company.supportsystem.domain.model.aggregates.Ticket;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final CreateTicketUseCaseImpl createTicketUseCase;
    private final GetAllTicketsUseCaseImpl getAllTicketsUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket createTicket(@Valid @RequestBody CreateTicketRequest request) {
        return createTicketUseCase.execute(
                request.getCustomerId(),
                "system-user",
                request.getDescription()
        );
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return getAllTicketsUseCase.execute();
    }
}
