package com.example.demo.entity;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
    Article findByDesignation(String designation);
}
