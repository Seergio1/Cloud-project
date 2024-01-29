package com.example.ventevoiture01.Models;

public class MeilleureVente {
    private Employer vendeur;
    private Long nombreVentes;

    public MeilleureVente() {
    }

    public MeilleureVente(Vendeur vendeur, Long nombreVentes) {
        this.vendeur = vendeur;
        this.nombreVentes = nombreVentes;
    }

    public Vendeur getVendeur() {
        return vendeur;
    }

    public void setVendeur(Vendeur vendeur) {
        this.vendeur = vendeur;
    }

    public Long getNombreVentes() {
        return nombreVentes;
    }

    public void setNombreVentes(Long nombreVentes) {
        this.nombreVentes = nombreVentes;
    }
}
