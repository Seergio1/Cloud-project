package com.example.stock.Repository;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.stock.Models.Article_in_stock;

@Repository
public interface Article_in_stockRepository extends JpaRepository<Article_in_stock,Long> {

    @Query("SELECT ais FROM article_in_stock ais WHERE ais.article.name = :nameArticle")
    List<Article_in_stock> findByNameArticle_in_stocks(@Param("nameArticle") String nameArticle);

    // FIFO
    @Query("SELECT ais FROM article_in_stock ais WHERE ais.quantity > 0 AND ais.article.code = :articleCode ORDER BY ais.date ASC")
    List<Article_in_stock> findArticleFIFO(@Param("articleCode") String articleCode);

    // LIFO
    @Query("SELECT ais FROM article_in_stock ais WHERE ais.quantity > 0 AND ais.article.code = :articleCode ORDER BY ais.date DESC")
    List<Article_in_stock> findArticleLIFO(@Param("articleCode") String articleCode);

   
    
    @Query("SELECT ais FROM article_in_stock ais order by id desc limit 1")
    Article_in_stock getLatestArticleInStock();

    @Query("SELECT ais FROM article_in_stock ais WHERE ais.article.id = :ida AND ais.magasin.id = :idm AND ais.date <= :date_repere ORDER BY ais.article.id")
    List<Article_in_stock> getStateArticle(@Param("ida") long id_article,@Param("idm") long id_magasin,@Param("date_repere") Timestamp date_);
}
