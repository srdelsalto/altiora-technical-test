package com.altiora.backend.altiorabackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "article")
@Getter
@Setter
@ToString
public class ArticleModel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String name;
    private Float unitaryPrice;

    @ManyToMany(mappedBy = "articles")
    @JsonIgnore
    private List<OrderModel> orders;
}
