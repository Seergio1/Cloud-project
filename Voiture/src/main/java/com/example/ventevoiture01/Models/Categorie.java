package com.example.ventevoiture01.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_categorie;
    String nom;

    public int getId() {
        return id_categorie;
    }

    @Override
    public String toString() {
        return "Categorie [id=" + id_categorie + ", nom=" + nom + "]";
    }


    public void setId(int id) {
        this.id_categorie = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    public Categorie() {
    }

    public Categorie(int id, String nom) {
        this.id_categorie = id;
        this.nom = nom;
    }
}