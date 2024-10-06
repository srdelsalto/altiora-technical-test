package com.altiora.backend.altiorabackend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code; //UNIQUE CODE OC-000001
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;

    @ManyToMany
    @JoinTable(
            name = "order_article",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    private List<ArticleModel> articles;
}
