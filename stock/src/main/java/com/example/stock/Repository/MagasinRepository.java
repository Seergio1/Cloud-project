package com.example.stock.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.stock.Models.Magasin;

@Repository
public interface MagasinRepository extends JpaRepository<Magasin,Long>{
    
}
