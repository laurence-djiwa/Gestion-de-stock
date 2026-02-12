package com.example.demo.kafka;

import com.example.demo.entity.Article;
import com.example.demo.entity.ArticleRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class StockConsumer {

    private final ArticleRepository articleRepository;

    public StockConsumer(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @KafkaListener(topics = "commandes", groupId = "my-first-group")
    public void consommerCommande(String message) {

        System.out.println("Message reçu : " + message);

        // format attendu : libelle,quantite
        String[] parts = message.split(",");
        String designation = parts[0];
        int quantite = Integer.parseInt(parts[1]);

        Article article = articleRepository.findByDesignation(designation);

        if (article != null) {
            article.setQuantite(article.getQuantite() - quantite);
            articleRepository.save(article);
        }
    }
}

