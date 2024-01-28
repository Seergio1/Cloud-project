package com.example.ventevoiture01.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ventevoiture01.Models.Annonce_Favoris;

@Repository
public interface AnnonceFavorisJPA extends JpaRepository<Annonce_Favoris, Integer> {

}