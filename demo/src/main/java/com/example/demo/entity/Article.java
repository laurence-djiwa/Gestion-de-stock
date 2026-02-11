package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String designation;
    private String description;
    private double prix;
    private int quantite;

    public Article(){

    }
    public Article(String nom, String description, double prix, int quantite){
        this.designation=nom;
        this.description=description;
        this.prix=prix;
        this.quantite=quantite;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public double getPrix(){
        return prix;
    }

    public void setPrix(double prix){
        this.prix=prix;
    }

    public void setQuantite(int quantite){
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }
}
