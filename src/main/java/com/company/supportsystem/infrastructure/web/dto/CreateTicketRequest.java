package com.company.supportsystem.infrastructure.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTicketRequest {

    @NotBlank
    private String customerId;

    @NotBlank
    private String description;
}

