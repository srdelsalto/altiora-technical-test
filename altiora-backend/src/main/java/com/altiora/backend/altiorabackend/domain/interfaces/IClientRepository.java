package com.altiora.backend.altiorabackend.domain.interfaces;

import com.altiora.backend.altiorabackend.application.dtos.request.CreateClientRequest;
import com.altiora.backend.altiorabackend.application.dtos.request.UpdateClientRequest;
import com.altiora.backend.altiorabackend.domain.entities.Client;

import java.util.List;

public interface IClientRepository {
    Client save(CreateClientRequest client);
    Client findById(Long id);
    List<Client> findAll();
    void delete(Long id);
    Client update(UpdateClientRequest client);
}
