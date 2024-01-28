package com.example.Voiture;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    int id_annonce;
    String url;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Image [id=" + id + ", id_annonce=" + id_annonce + ", url=" + url + "]";
    }

    public Image(int id_annonce, String url) {
        this.id_annonce = id_annonce;
        this.url = url;
    }

    public Image() {
    }

    public Image(int id, int id_annonce, String url) {
        this.id = id;
        this.id_annonce = id_annonce;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}