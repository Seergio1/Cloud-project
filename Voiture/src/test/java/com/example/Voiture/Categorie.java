package com.example.Voiture;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Categorie [id=" + id + ", nom=" + nom + "]";
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    public Categorie() {
    }

    public Categorie(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    String nom;
}