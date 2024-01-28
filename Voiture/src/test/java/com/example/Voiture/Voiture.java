package com.example.Voiture;

public class Voiture {
    int id;
    int id_marque;

    @Override
    public String toString() {
        return "Voiture [id=" + id + ", id_marque=" + id_marque + ", id_modele=" + id_modele + ", etat=" + etat
                + ", prix=" + prix + ", matricule=" + matricule + "]";
    }

    int id_modele;
    int etat;

    public Voiture(int id, int id_marque, int id_modele, int etat, double prix, String matricule) {
        this.id = id;
        this.id_marque = id_marque;
        this.id_modele = id_modele;
        this.etat = etat;
        this.prix = prix;
        this.matricule = matricule;
    }

    public Voiture(int id_marque, int id_modele, int etat, double prix, String matricule) {
        this.id_marque = id_marque;
        this.id_modele = id_modele;
        this.etat = etat;
        this.prix = prix;
        this.matricule = matricule;
    }

    public Voiture() {
    }

    double prix;
    String matricule;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_marque() {
        return id_marque;
    }

    public void setId_marque(int id_marque) {
        this.id_marque = id_marque;
    }

    public int getId_modele() {
        return id_modele;
    }

    public void setId_modele(int id_modele) {
        this.id_modele = id_modele;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

}