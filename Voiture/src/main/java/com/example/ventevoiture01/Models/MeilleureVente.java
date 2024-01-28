package com.example.ventevoiture01.Models;

public class MeilleureVente {
    private Long idVendeur;
    private Long nombreVentes;

    public VenteCountDTO() {
    }

    public VenteCountDTO(Long idVendeur, Long nombreVentes) {
        this.idVendeur = idVendeur;
        this.nombreVentes = nombreVentes;
    }

    public Long getIdVendeur() {
        return idVendeur;
    }

    public void setIdVendeur(Long idVendeur) {
        this.idVendeur = idVendeur;
    }

    public Long getNombreVentes() {
        return nombreVentes;
    }

    public void setNombreVentes(Long nombreVentes) {
        this.nombreVentes = nombreVentes;
    }
}
