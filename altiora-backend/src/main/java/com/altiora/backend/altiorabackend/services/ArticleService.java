package com.altiora.backend.altiorabackend.services;

import com.altiora.backend.altiorabackend.models.ArticleModel;
import com.altiora.backend.altiorabackend.infraestructure.repositories.jpa.ArticleRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepositoryJPA articleRepository;

    public ArticleModel createArticle(ArticleModel articleModel) {
        return articleRepository.save(articleModel);
    }

    public List<ArticleModel> listArticles() {
        return articleRepository.findAll();
    }
}
