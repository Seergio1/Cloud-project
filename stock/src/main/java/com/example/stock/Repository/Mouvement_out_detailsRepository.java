package com.example.stock.Repository;

import org.springframework.stereotype.Repository;

import com.example.stock.Models.Mouvement_out_details;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface Mouvement_out_detailsRepository extends JpaRepository<Mouvement_out_details,Long>{
    
}
