package com.example.stock.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.stock.Models.Article_magasin;


@Repository
public interface Article_magasinRepository extends JpaRepository<Article_magasin,Long> {
    @Query("SELECT am from article_magasin am WHERE am.article.id = :ida AND am.magasin.id = :idm")
    Article_magasin getIfArticleExistsByArticleAndMagasin(@Param("ida") long id_article ,@Param("idm") long id_magasin);

    @Query("SELECT ais FROM article_magasin ais WHERE ais.magasin.id = :idm ORDER BY ais.article.id desc limit 1")
    List<Article_magasin> getArticle_in_stocksByIdMagasin(@Param("idm") long id_magasin);

}

 