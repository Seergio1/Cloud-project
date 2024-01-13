package com.example.stock.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Models.Magasin;
import com.example.stock.Repository.MagasinRepository;

@Service
public class MagasinService {
    @Autowired
    MagasinRepository magasinRepository;

    public List<Magasin> getAllMagasin(){
        return magasinRepository.findAll();
    }

    public Optional<Magasin> getMagasinById(Long id){
        return magasinRepository.findById(id);
    }
}
