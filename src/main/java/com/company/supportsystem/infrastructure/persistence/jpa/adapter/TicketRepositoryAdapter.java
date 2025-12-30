package com.company.supportsystem.infrastructure.persistence.jpa.adapter;

import com.company.supportsystem.domain.model.aggregates.Ticket;
import com.company.supportsystem.domain.model.valueobjects.TicketId;
import com.company.supportsystem.domain.repository.TicketRepository;
import com.company.supportsystem.infrastructure.persistence.jpa.mapper.TicketEntityMapper;
import com.company.supportsystem.infrastructure.persistence.jpa.repository.SpringDataTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TicketRepositoryAdapter implements TicketRepository {

    private final SpringDataTicketRepository repository;

    @Override
    public Ticket save(Ticket ticket) {
        repository.save(TicketEntityMapper.toEntity(ticket));
        return ticket;
    }

    @Override
    public List<Ticket> findAll() {
        return repository
                .findAll()
                .stream()
                .map(TicketEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Ticket> findById(TicketId id) {
        return repository.findById(id.value())
                .map(TicketEntityMapper::toDomain);
    }

    @Override
    public List<Ticket> findAllActive() {
        return repository.findAllActive()
                .stream()
                .map(TicketEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Ticket> findClosedByCustomerId(String customerId) {
        return repository.findClosedByCustomerId(customerId)
                .stream()
                .map(TicketEntityMapper::toDomain)
                .toList();
    }
}
