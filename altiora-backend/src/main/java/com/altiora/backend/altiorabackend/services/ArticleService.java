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

    public ArticleModel getArticleById(String id) {
        return articleRepository.findById(id).orElse(null);
    }

    public ArticleModel updateArticle(ArticleModel articleModel) {
        ArticleModel article = articleRepository.findById(articleModel.getId())
                .orElseThrow(() -> new RuntimeException("Artícle not found!"));

        article.setName(articleModel.getName());
        article.setUnitaryPrice(articleModel.getUnitaryPrice());
        return articleRepository.save(article);
    }

    public void deleteArticle(String articleId) {
        articleRepository.deleteById(articleId);
    }
}
