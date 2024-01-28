package com.example.Voiture.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    int id_marque;
    String nom;

    @Override
    public String toString() {
        return "Modele [id=" + id + ", id_marque=" + id_marque + ", nom=" + nom + "]";
    }

    public Modele(int id, int id_marque, String nom) {
        this.id = id;
        this.id_marque = id_marque;
        this.nom = nom;
    }

    public Modele(int id_marque, String nom) {
        this.id_marque = id_marque;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Modele() {
    }

    public int getId_marque() {
        return id_marque;
    }

    public void setId_marque(int id_marque) {
        this.id_marque = id_marque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}