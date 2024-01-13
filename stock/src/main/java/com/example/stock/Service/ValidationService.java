package com.example.stock.Service;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Models.Article;
import com.example.stock.Models.Magasin;
import com.example.stock.Models.Mouvement;
import com.example.stock.Models.Validation;
import com.example.stock.Repository.MouvementRepository;
import com.example.stock.Repository.ValidationRepository;

import jakarta.transaction.Transactional;

@Service
public class ValidationService {

    @Autowired
    MouvementRepository mouvementRepository;

    @Autowired
    MouvementService mouvementService;

    @Autowired
    Article_in_stockService article_in_stockService;

    @Autowired
    ValidationRepository validationRepository;

    @Autowired
    Etat_stockService etat_stockService;

    @Autowired
    ArticleService articleService;

    @Autowired 
    MagasinService magasinService;

    public void addMouvementValidate(Mouvement mouvement){
        Validation validate = Validation.builder()
        .mouvementValider(mouvement)
        .date_validation(mouvement.getDate())
        .build();
        validationRepository.save(validate);
    }

    @Transactional
    public void validateEtatMouvement(Mouvement mouvement_a_valider,Timestamp date_validation){
        Mouvement checkMouvInvalidate = mouvementRepository.getMouvementInvalidateByIdMouvement(mouvement_a_valider.getId());
        System.out.println(checkMouvInvalidate);

        if(checkMouvInvalidate != null){
            mouvementService.updateEtatMouvement(checkMouvInvalidate,date_validation);
        Article article = articleService.getArticleById(mouvement_a_valider.getArticle().getId())
        .orElseThrow(() -> new IllegalStateException("Article with id" + mouvement_a_valider.getArticle().getId()+ "does not exists"));
        Magasin magasin = magasinService.getMagasinById(mouvement_a_valider.getMagasin().getId())
        .orElseThrow(() -> new IllegalStateException("Magasin with id" + mouvement_a_valider.getMagasin().getId()+ "does not exists"));
        
           
            double price = mouvement_a_valider.getPrice_unity();
            double quantite = mouvement_a_valider.getQuantity();
            String status = mouvement_a_valider.getStatus_direction();

            Mouvement mouvementValidate = Mouvement.builder()
            .article(article)
            .date(date_validation)
            .magasin(magasin)
            .price_unity(price)
            .quantity(quantite)
            .status_direction(status)
            .etat(checkMouvInvalidate.getEtat())
            .build();

            // mouvementService.updateMouvementInvalidate();
            addMouvementValidate(mouvementValidate);
            // article_in_stockService.addArticleInStock(mouvementValidate);
            // etat_stockService.registerEtat(checkMouvInvalidate.getMagasin(),date_validation);
        }else{
            throw new NullPointerException("Le mouvement avec l'id : "+ mouvement_a_valider.getId()+" est déjà validé");
        }
    }

}
