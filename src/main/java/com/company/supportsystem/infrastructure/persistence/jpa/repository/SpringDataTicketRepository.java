package com.company.supportsystem.infrastructure.persistence.jpa.repository;

import com.company.supportsystem.infrastructure.persistence.jpa.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataTicketRepository extends JpaRepository<TicketEntity, String> {
    List<TicketEntity> findByStatusNot(String status);

    List<TicketEntity> findByStatusAndCustomerId(String status, String customerId);

    default List<TicketEntity> findAllActive() {
        return findByStatusNot("CLOSED");
    }

    default List<TicketEntity> findClosedByCustomerId(String customerId) {
        return findByStatusAndCustomerId("CLOSED", customerId);
    }
}
