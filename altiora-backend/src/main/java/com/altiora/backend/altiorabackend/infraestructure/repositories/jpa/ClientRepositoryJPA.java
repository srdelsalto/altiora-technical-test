package com.altiora.backend.altiorabackend.infraestructure.repositories.jpa;

import com.altiora.backend.altiorabackend.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoryJPA extends JpaRepository<ClientModel, Long> {
    ClientModel getClientById(Long id);
}
