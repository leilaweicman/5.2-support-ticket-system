package com.company.supportsystem.infrastructure.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateTicketRequest {

    @NotBlank
    private String customerId;

    @NotBlank
    private String description;
}

