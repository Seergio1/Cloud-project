package com.example.stock.Repository;

import org.springframework.stereotype.Repository;

import com.example.stock.Models.EtatStock;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface Etat_stockRepository extends JpaRepository<EtatStock,Long>{

    @Query("SELECT es FROM etat_stock es WHERE es.article.id = :ida AND es.magasin.id = :idm AND es.date = :date_repere")
    EtatStock getEtatStockFromArticleAndMagasin(@Param("ida") long id_article,@Param("idm") long id_magasin, @Param("date_repere") Timestamp date);

    @Query("SELECT es FROM etat_stock es WHERE es.magasin.id = :idm AND es.date = :date_repere")
    List<EtatStock> getEtatStockFromMagasin(@Param("idm") long id_magasin, @Param("date_repere") Timestamp date);

    @Query("SELECT es FROM etat_stock es WHERE es.article.id = :ida AND es.magasin.id = :idm AND es.date <= :date_repere ORDER BY es.date DESC limit 1")
    Optional<EtatStock> getEtatStockNearestDateByArticle(@Param("ida") long id_article,@Param("idm") long id_magasin, @Param("date_repere") Timestamp date);

    @Query("SELECT es FROM etat_stock es WHERE es.magasin.id = :idm AND es.date <= :date_repere ORDER BY es.date DESC limit 1")
    Optional<EtatStock> getEtatStockNearestDateByMagasin(@Param("idm") long id_magasin, @Param("date_repere") Timestamp date);

    @Query("SELECT es FROM etat_stock es WHERE es.magasin.id = :idm AND es.date > :date_repere ORDER BY es.date DESC limit 1")
    Optional<EtatStock> getAboveDate(@Param("idm") long id_magasin, @Param("date_repere") Timestamp date);

}
