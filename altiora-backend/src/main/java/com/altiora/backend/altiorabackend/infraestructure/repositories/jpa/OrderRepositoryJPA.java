package com.altiora.backend.altiorabackend.infraestructure.repositories.jpa;


import com.altiora.backend.altiorabackend.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryJPA extends JpaRepository<OrderModel, Long> {
}
