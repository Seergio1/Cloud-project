package com.example.Voiture.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String nom;
    String email;

    public Utilisateur(String nom, String email, String mdp, int is_admin) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.is_admin = is_admin;
    }

    String mdp;
    int is_admin;

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", email=" + email + ", mdp=" + mdp + ", is_admin=" + is_admin
                + "]";
    }

    public int getId() {
        return id;
    }

    public Utilisateur(int id, String nom, String email, String mdp, int is_admin) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.is_admin = is_admin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

}