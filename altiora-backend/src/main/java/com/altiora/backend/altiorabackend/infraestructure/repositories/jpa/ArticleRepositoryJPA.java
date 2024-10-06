package com.altiora.backend.altiorabackend.infraestructure.repositories.jpa;

import com.altiora.backend.altiorabackend.models.ArticleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepositoryJPA extends JpaRepository<ArticleModel, String> {
}
