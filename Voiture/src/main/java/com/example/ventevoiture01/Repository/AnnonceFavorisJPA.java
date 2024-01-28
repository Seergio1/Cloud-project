package com.example.ventevoiture01.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ventevoiture01.Models.Annonce_Favoris;
import com.example.ventevoiture01.Models.MeilleureAnnonce;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface AnnonceFavorisJPA extends JpaRepository<Annonce_Favoris, Integer> {
  @Query(value = "SELECT a, COUNT(*) AS favorisCount " +
            "FROM AnnonceFavoris af " +
            "JOIN af.annonce a " +
            "GROUP BY a " +
            "ORDER BY favorisCount DESC")
    List<MeilleureAnnonce> countFavorisByAnnonce();
}
