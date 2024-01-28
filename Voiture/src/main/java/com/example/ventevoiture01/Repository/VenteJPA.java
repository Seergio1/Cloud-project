package com.example.ventevoiture01.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ventevoiture01.Models.Vente;

@Repository
public interface VenteJPA extends JpaRepository<Vente, Integer> {
    
    @Query(value = "SELECT id_vendeur, COUNT(*) AS nombre_ventes " +
            "FROM vente " +
            "GROUP BY id_vendeur " +
            "ORDER BY nombre_ventes DESC", nativeQuery = true)
    List<Vente> countVentesParVendeur();
    
}
