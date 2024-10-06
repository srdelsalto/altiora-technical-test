package com.altiora.backend.altiorabackend.application.dtos.response;

import com.altiora.backend.altiorabackend.domain.entities.Article;
import com.altiora.backend.altiorabackend.domain.entities.Client;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GetOrderResponse {
    private Long id;
    private String code;
    private LocalDate date;
    private Client client;
    private Article article;
}
