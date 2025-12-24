package com.company.supportsystem.infrastructure.web.controller;

import com.company.supportsystem.infrastructure.web.dto.CreateTicketRequest;
import com.company.supportsystem.application.usecase.ticket.CreateTicketUseCaseImpl;
import com.company.supportsystem.domain.model.aggregates.Ticket;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketController {

    private final CreateTicketUseCaseImpl createTicketUseCase;

    public TicketController(CreateTicketUseCaseImpl createTicketUseCase) {
        this.createTicketUseCase = createTicketUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket createTicket(@Valid @RequestBody CreateTicketRequest request) {
        return createTicketUseCase.execute(
                request.getCustomerId(),
                "system-user",
                request.getDescription()
        );
    }
}
