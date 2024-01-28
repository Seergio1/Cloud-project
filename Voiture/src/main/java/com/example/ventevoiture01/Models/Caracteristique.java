package com.example.ventevoiture01.Models;

import jakarta.persistence.*;

@Entity
public class Caracteristique {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_caracteristique;
    @ManyToOne
    @JoinColumn(name = "id_voiture")
    Voiture voiture;
    @ManyToOne
    @JoinColumn(name = "id_moteur")
    Moteur moteur;
    @ManyToOne
    @JoinColumn(name = "id_boite_de_vitesse")
    Boite_de_Vitesse boite_de_vitesse;
    @ManyToOne
    @JoinColumn(name = "id_carburant")
    Carburant carburant;
    @ManyToOne
    @JoinColumn(name = "id_couleur")
    Couleur couleur;

    public Caracteristique(int id_caracteristique, Voiture voiture, Moteur moteur, Boite_de_Vitesse boite_de_vitesse,
            Carburant carburant, Couleur couleur, double kilometrage, int annee, int puissance) {
        this.id_caracteristique = id_caracteristique;
        this.voiture = voiture;
        this.moteur = moteur;
        this.boite_de_vitesse = boite_de_vitesse;
        this.carburant = carburant;
        this.couleur = couleur;
        this.kilometrage = kilometrage;
        this.annee = annee;
        this.puissance = puissance;
    }

    @Override
    public String toString() {
        return "Caracteristique [id_caracteristique=" + id_caracteristique + ", voiture=" + voiture + ", moteur="
                + moteur + ", boite_de_vitesse=" + boite_de_vitesse + ", carburant=" + carburant + ", couleur="
                + couleur + ", kilometrage=" + kilometrage + ", annee=" + annee + ", puissance=" + puissance + "]";
    }

    public Caracteristique() {
    }

    public Caracteristique(Voiture voiture, Moteur moteur, Boite_de_Vitesse boite_de_vitesse, Carburant carburant,
            Couleur couleur, double kilometrage, int annee, int puissance) {
        this.voiture = voiture;
        this.moteur = moteur;
        this.boite_de_vitesse = boite_de_vitesse;
        this.carburant = carburant;
        this.couleur = couleur;
        this.kilometrage = kilometrage;
        this.annee = annee;
        this.puissance = puissance;
    }

    double kilometrage;

    public int getId_caracteristique() {
        return id_caracteristique;
    }

    public void setId_caracteristique(int id_caracteristique) {
        this.id_caracteristique = id_caracteristique;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Moteur getMoteur() {
        return moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    public Boite_de_Vitesse getBoite_de_vitesse() {
        return boite_de_vitesse;
    }

    public void setBoite_de_vitesse(Boite_de_Vitesse boite_de_vitesse) {
        this.boite_de_vitesse = boite_de_vitesse;
    }

    public Carburant getCarburant() {
        return carburant;
    }

    public void setCarburant(Carburant carburant) {
        this.carburant = carburant;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    int annee;
    int puissance;

}