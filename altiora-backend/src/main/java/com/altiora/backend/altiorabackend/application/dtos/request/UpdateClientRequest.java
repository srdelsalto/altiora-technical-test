package com.altiora.backend.altiorabackend.application.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateClientRequest {
    private Long id;
    private String firstName;
    private String lastName;
}
