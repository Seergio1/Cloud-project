package com.example.Voiture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceFavorisJPA extends JpaRepository<Annonce_Favoris, Integer> {

}