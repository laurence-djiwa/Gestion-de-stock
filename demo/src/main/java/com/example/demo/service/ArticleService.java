package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.entity.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ArticleService {
    private ArticleRepository repo;

    public ArticleService(ArticleRepository repo){
        this.repo = repo;
    }

    public void ajouterArticle(String nom, String description, double prix, int quantite){
        Article article = new Article(nom, description, prix, quantite);
        repo.save(article);
    }

    public void supprimerArticle(Integer id){
        repo.deleteById(id);
    }

    public void diminuerQuantite(Integer id, int qteSortante){
        Article article = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Article introuvable"));

        if (article.getQuantite() < qteSortante) {
            throw new IllegalStateException("Stock insuffisant");
        }

        int qteRestante = article.getQuantite() - qteSortante;
        article.setQuantite(qteRestante);
        repo.save(article);
    }

    public Iterable<Article> listeArticles() {
        return repo.findAll();
    }
}
