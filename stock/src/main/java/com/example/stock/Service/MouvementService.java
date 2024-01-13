package com.example.stock.Service;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Models.Article;
import com.example.stock.Models.Article_in_stock;
import com.example.stock.Models.Article_magasin;
import com.example.stock.Models.EtatStock;
import com.example.stock.Models.Magasin;
import com.example.stock.Models.Mouvement;
import com.example.stock.Repository.Article_in_stockRepository;
import com.example.stock.Repository.Article_magasinRepository;
import com.example.stock.Repository.Etat_stockRepository;
import com.example.stock.Repository.MouvementRepository;

import jakarta.transaction.Transactional;

@Service
public class MouvementService {
    @Autowired
    MouvementRepository mouvementRepository;

    @Autowired 
    Article_magasinRepository article_magasinRepository;

    @Autowired
    Article_in_stockService article_in_stockService;

    @Autowired
    Article_magasinService article_magasinService;

    @Autowired
    Etat_stockService etat_stockService;

    @Autowired
    Article_in_stockRepository article_in_stockRepository;

    @Autowired
    Etat_stockRepository etat_stockRepository;

    @Autowired
    ArticleService articleService;

    @Autowired
    MagasinService magasinService;


    public void addNewMouvement(Mouvement mouvement){
        Article_magasin articleMagasin = article_magasinRepository.getIfArticleExistsByArticleAndMagasin(mouvement.getArticle().getId(),mouvement.getMagasin().getId());
       
        Article article = articleService.getArticleById(mouvement.getArticle().getId())
        .orElseThrow(() -> new IllegalStateException("Article with id" + mouvement.getArticle().getId()+ "does not exists"));
        Magasin magasin = magasinService.getMagasinById(mouvement.getMagasin().getId())
        .orElseThrow(() -> new IllegalStateException("Magasin with id" + mouvement.getMagasin().getId()+ "does not exists"));
        
        if(articleMagasin == null){
            Article_magasin article_magasin = Article_magasin.builder()
            .article(article)
            .magasin(magasin)
            .build();
            article_magasinService.addNewArticle(article_magasin);
        }

        

        

            
            
            Mouvement newMouvement = Mouvement.builder()
            .article(article)
            .magasin(magasin)
            .date(mouvement.getDate())
            .price_unity(mouvement.getPrice_unity())
            .status_direction(mouvement.getStatus_direction())
            .quantity(mouvement.getQuantity())
            .etat(mouvement.getEtat())
            .build();


            if(mouvement.getStatus_direction().equalsIgnoreCase("in")){
                if(mouvement.getPrice_unity()>0 && mouvement.getQuantity()>0){
                    mouvementRepository.save(newMouvement);

                    // article_in_stockService.addArticleInStock(newMouvement);
                    // registerEtat(magasin,newMouvement.getDate());
                }
            }else{
                if(mouvement.getQuantity()>0){
                    mouvementRepository.save(newMouvement);

                    // article_in_stockService.addArticleInStock(newMouvement);
                    // registerEtat(magasin,newMouvement.getDate());
                }
            }
            
            
            
            
            
            
            
        
        
    }

   


    @Transactional
    public void updateMouvementOut(Mouvement mouvement){
        mouvement.setPrice_unity(mouvement.getPrice_unity());
    }

    @Transactional
    public void updateEtatMouvement(Mouvement mouvement,Timestamp date_validation){
        mouvement.setEtat(10);
        // mouvement.setDate(date_validation);
    }

    @Transactional
    public void updateMouvementInvalidate(Mouvement mouvement){
        Mouvement mouvement_a_updater = mouvementRepository.findById(mouvement.getId())
        .orElseThrow(() -> new IllegalStateException("Mouvement with id" + mouvement.getId()+ "does not exists"));

        mouvement_a_updater.setArticle(mouvement.getArticle());
        mouvement_a_updater.setMagasin(mouvement.getMagasin());
        mouvement_a_updater.setStatus_direction(mouvement.getStatus_direction());
       

        if(mouvement.getQuantity() >= 0 && mouvement.getPrice_unity() >= 0){
            mouvement_a_updater.setQuantity(mouvement.getQuantity());

            if(mouvement_a_updater.getStatus_direction().equalsIgnoreCase("in")){
                mouvement_a_updater.setPrice_unity(mouvement.getPrice_unity());
            }
        }else{
            throw new IllegalStateException("Quantity/Price invalid during updating invalidate mouvement");
        }
        
    }
    

    

}
