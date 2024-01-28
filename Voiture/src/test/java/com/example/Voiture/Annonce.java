package com.example.Voiture;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    int id_voiture;
    int id_utilisateur;
    String description;
    String etat_annonce;

    public Annonce(int id, int id_voiture, int id_utilisateur, String description, String etat_annonce,
            String status_voiture, Date date) {
        this.id = id;
        this.id_voiture = id_voiture;
        this.id_utilisateur = id_utilisateur;
        this.description = description;
        this.etat_annonce = etat_annonce;
        this.status_voiture = status_voiture;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Annonce [id=" + id + ", id_voiture=" + id_voiture + ", id_utilisateur=" + id_utilisateur
                + ", description=" + description + ", etat_annonce=" + etat_annonce + ", status_voiture="
                + status_voiture + ", date=" + date + "]";
    }

    public Annonce(int id_voiture, int id_utilisateur, String description, String etat_annonce, String status_voiture,
            Date date) {
        this.id_voiture = id_voiture;
        this.id_utilisateur = id_utilisateur;
        this.description = description;
        this.etat_annonce = etat_annonce;
        this.status_voiture = status_voiture;
        this.date = date;
    }

    public Annonce() {
    }

    String status_voiture;
    Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat_annonce() {
        return etat_annonce;
    }

    public void setEtat_annonce(String etat_annonce) {
        this.etat_annonce = etat_annonce;
    }

    public String getStatus_voiture() {
        return status_voiture;
    }

    public void setStatus_voiture(String status_voiture) {
        this.status_voiture = status_voiture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}