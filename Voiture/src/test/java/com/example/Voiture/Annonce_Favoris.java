package com.example.Voiture;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Annonce_Favoris {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    int id_annonce;
    int id_utilisateur;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Annonce_Favoris [id=" + id + ", id_annonce=" + id_annonce + ", id_utilisateur=" + id_utilisateur + "]";
    }

    public Annonce_Favoris(int id_annonce, int id_utilisateur) {
        this.id_annonce = id_annonce;
        this.id_utilisateur = id_utilisateur;
    }

    public Annonce_Favoris() {
    }

    public Annonce_Favoris(int id, int id_annonce, int id_utilisateur) {
        this.id = id;
        this.id_annonce = id_annonce;
        this.id_utilisateur = id_utilisateur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

}