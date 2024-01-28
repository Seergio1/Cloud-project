package com.example.Voiture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeleJPA extends JpaRepository<Modele, Integer> {

}