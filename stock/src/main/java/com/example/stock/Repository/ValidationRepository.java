package com.example.stock.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.stock.Models.Validation;

@Repository
public interface ValidationRepository extends JpaRepository<Validation,Long> {
    @Query("SELECT va FROM validation va WHERE va.mouvementValider.article.id = :ida AND va.mouvementValider.magasin.id = :idm")
    List<Validation> geValidation(@Param("ida") long id_article,@Param("idm") long id_magasin);
}
