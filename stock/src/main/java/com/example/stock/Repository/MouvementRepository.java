package com.example.stock.Repository;

import java.sql.Timestamp;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.stock.Models.Article;
import com.example.stock.Models.Magasin;
import com.example.stock.Models.Mouvement;

public interface MouvementRepository extends JpaRepository<Mouvement,Long> {
    @Query("SELECT ar FROM mouvement ar WHERE ar.article.id = :ida AND ar.magasin.id = :idm AND ar.date >= :d_debut AND ar.date <= :d_fin ORDER BY date DESC")
    List<Mouvement> findMouvementBetween(@Param("ida") long id_article, @Param("idm") long id_magasin ,@Param("d_debut") Timestamp date_debut, @Param("d_fin") Timestamp date_fin);

    @Query("SELECT ar FROM mouvement ar WHERE ar.etat = 20")
    List<Mouvement> getAllMouvInvalidate();

    @Query("SELECT ar FROM mouvement ar WHERE ar.etat = 20 AND ar.id = :idmouv")
    Mouvement getMouvementInvalidateByIdMouvement(@Param("idmouv") long id_mouvement);

    List<Mouvement> findAllByArticleAndMagasinAndEtat(Article article,Magasin magasin,Integer etat);

}
