package com.example.stock.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Models.ArticleStockQuantity;
import com.example.stock.Models.Mouvement;
import com.example.stock.Models.Mouvement_out_details;
import com.example.stock.Repository.Mouvement_out_detailsRepository;

import jakarta.transaction.Transactional;

@Service
public class Mouvement_out_detailsService {

    @Autowired
    Mouvement_out_detailsRepository mouvement_out_detailsRepository;

    public void addNewMouvementDetails(List<ArticleStockQuantity> articleStock, Mouvement mouvementOut){
        for(ArticleStockQuantity articleStockQuantity : articleStock){
            Mouvement_out_details mDetails = Mouvement_out_details.builder()
            .mouvement_in(articleStockQuantity.getArticle_in_stock().getMouvement())
            .mouvement_out(mouvementOut)
            .quantity(articleStockQuantity.getQuantity())
            .build();
            mouvement_out_detailsRepository.save(mDetails);
            
        }
        
    }
}
