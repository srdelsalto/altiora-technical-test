package com.altiora.backend.altiorabackend.application.dtos.response;

import com.altiora.backend.altiorabackend.domain.entities.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUpdateClientResponse {
    private String message;
    private Client client;
}
