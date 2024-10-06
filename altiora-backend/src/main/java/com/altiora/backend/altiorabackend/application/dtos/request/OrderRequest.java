package com.altiora.backend.altiorabackend.application.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private Long clientId;
    private LocalDate date;
    private List<String> articleIds;
}
