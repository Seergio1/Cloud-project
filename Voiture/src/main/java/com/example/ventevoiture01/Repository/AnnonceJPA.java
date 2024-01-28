package com.example.ventevoiture01.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ventevoiture01.Models.Annonce;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AnnonceJPA extends JpaRepository<Annonce, Integer> {
     Annonce findByid_annonce(int id_annonce);
}
