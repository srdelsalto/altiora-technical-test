package com.altiora.backend.altiorabackend.controllers;

import com.altiora.backend.altiorabackend.models.ArticleModel;
import com.altiora.backend.altiorabackend.services.ArticleService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
@CrossOrigin("*")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleModel> createArticle(@RequestBody ArticleModel articleModel) {
        ArticleModel createdArticleModel = articleService.createArticle(articleModel);

        return new ResponseEntity<>(createdArticleModel, HttpStatus.CREATED);
    }

    // Listar todos los artículos
    @GetMapping
    public ResponseEntity<List<ArticleModel>> listArticles() {
        return new ResponseEntity<>(articleService.listArticles(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ArticleModel> updateArticle(@RequestBody ArticleModel articleModel) {
        var article = articleService.updateArticle(articleModel);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ArticleModel> deleteArticle(@PathParam("id") String id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
