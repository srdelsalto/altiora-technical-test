package com.altiora.backend.altiorabackend.application.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClientRequest {
    private String firstName;
    private String lastName;
}
