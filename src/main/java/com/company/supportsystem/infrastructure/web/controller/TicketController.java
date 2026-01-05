package com.company.supportsystem.infrastructure.web.controller;

import com.company.supportsystem.application.usecase.ticket.*;
import com.company.supportsystem.infrastructure.web.dto.AssignTicketRequest;
import com.company.supportsystem.infrastructure.web.dto.CreateTicketRequest;
import com.company.supportsystem.domain.model.aggregates.Ticket;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final CreateTicketUseCaseImpl createTicketUseCase;
    private final GetAllTicketsUseCaseImpl getAllTicketsUseCase;
    private final GetTicketByIdUseCaseImpl getTicketByIdUseCase;
    private final AssignTicketUseCase assignTicketUseCase;
    private final StartTicketProgressUseCase startTicketProgressUseCase;

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

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable String id) {
        return getTicketByIdUseCase.execute(id);
    }

    @PostMapping("/{id}/assign")
    public ResponseEntity<Void> assignTicket(
            @PathVariable String id,
            @RequestBody AssignTicketRequest request
    ) {
        assignTicketUseCase.execute(id, request.technicianUserId());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/start-progress")
    public Ticket startProgress(@PathVariable String id) {
        return startTicketProgressUseCase.execute(id);
    }

}
