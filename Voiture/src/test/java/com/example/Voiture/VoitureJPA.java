package com.example.Voiture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureJPA extends JpaRepository<Voiture, Integer> {

}