package com.example.stock.Service;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Models.Article;
import com.example.stock.Models.Article_in_stock;
import com.example.stock.Models.Article_magasin;
import com.example.stock.Models.EtatStock;
import com.example.stock.Models.EtatStockReponse;
import com.example.stock.Models.Magasin;
import com.example.stock.Models.Mouvement;
import com.example.stock.Models.Validation;
import com.example.stock.Repository.Article_in_stockRepository;
import com.example.stock.Repository.Article_magasinRepository;
import com.example.stock.Repository.Etat_stockRepository;
import com.example.stock.Repository.MouvementRepository;
import com.example.stock.Repository.ValidationRepository;

@Service
public class Etat_stockService {
    @Autowired
    Etat_stockRepository etat_stockRepository;

    @Autowired
    MouvementRepository mouvementRepository;

    @Autowired
    Article_in_stockRepository article_in_stockRepository;

    @Autowired
    Article_magasinRepository article_magasinRepository;

    @Autowired
    ValidationRepository validationRepository;

    public void addNewEtatStock(EtatStock etatStock){
        
        etat_stockRepository.save(etatStock);
    }

    public List<EtatStockReponse> gEtatStockByArticleAndMagasin(long id_article,long id_magasin,Timestamp date_first,Timestamp date_second){
        List<EtatStockReponse> resultatStock = new Vector<EtatStockReponse>();
        
        Optional<EtatStock> nearestDateFirst = etat_stockRepository.getEtatStockNearestDateByArticle(id_article,id_magasin, Timestamp.from(date_first.toInstant().minus((long)3,ChronoUnit.HOURS)));
        Optional<EtatStock> nearestDateSecond = etat_stockRepository.getEtatStockNearestDateByArticle(id_article,id_magasin, Timestamp.from(date_second.toInstant().minus((long)3,ChronoUnit.HOURS)));
        
        Timestamp date_debut = nearestDateFirst.get().getDate();
        Timestamp date_fin = nearestDateSecond.get().getDate();
        EtatStock firstEtat = etat_stockRepository.getEtatStockFromArticleAndMagasin(id_article,id_magasin,date_debut);
        EtatStock secondEtat = etat_stockRepository.getEtatStockFromArticleAndMagasin(id_article, id_magasin, date_fin);

        List<Mouvement> mouv = getAllDetailsMouvement(firstEtat, secondEtat);
        List<EtatStockReponse> reponses = new Vector<EtatStockReponse>();
        reponses.add(EtatStockReponse.builder()
        .etat_debut(firstEtat)
        .etat_fin(secondEtat)
        .listeMouvement(mouv)
        .build());

        return reponses;
        
    }

    public List<EtatStockReponse> getEtatStockByMagasin(long id_magasin,Timestamp date_first,Timestamp date_second){
        List<EtatStockReponse> resultatStock = new Vector<EtatStockReponse>();

        

        Optional<EtatStock> nearestDateFirst = etat_stockRepository.getEtatStockNearestDateByMagasin(id_magasin, Timestamp.from(date_first.toInstant().minus((long)3,ChronoUnit.HOURS)));
        Optional<EtatStock> nearestDateSecond = etat_stockRepository.getEtatStockNearestDateByMagasin(id_magasin, Timestamp.from(date_second.toInstant().minus((long)3,ChronoUnit.HOURS)));
        
        Timestamp date_debut = nearestDateFirst.get().getDate();
        Timestamp date_fin = nearestDateSecond.get().getDate();

        List<EtatStock> resultatStockFirst = etat_stockRepository.getEtatStockFromMagasin(id_magasin, date_debut);
        List<EtatStock> resultatStockSecond = etat_stockRepository.getEtatStockFromMagasin(id_magasin, date_fin);

        System.out.println("debut");
        System.out.println(Timestamp.from(date_first.toInstant().minus((long)3,ChronoUnit.HOURS)));
        System.out.println("fin");
        System.out.println(Timestamp.from(date_second.toInstant().minus((long)3,ChronoUnit.HOURS)));
        System.out.println("mouvement");
        for(EtatStock etatStock : resultatStockFirst){
            System.out.println(etatStock.getDate());
        }
        
    
        return buildEtatStockReponse(resultatStockFirst, resultatStockSecond);
    }

    public List<EtatStockReponse> buildEtatStockReponse(List<EtatStock> list_etat_debut,List<EtatStock> list_etat_fin){
        List<EtatStockReponse> response = new Vector<EtatStockReponse>();
        if(list_etat_debut.size() > 0){
            for(int i = 0;i<list_etat_debut.size();i++){
                List<Mouvement> mouv = getAllDetailsMouvement(list_etat_debut.get(i), list_etat_fin.get(i));
                response.add(EtatStockReponse.builder().etat_debut(list_etat_debut.get(i))
                .etat_fin(list_etat_fin.get(i))
                .listeMouvement(mouv)
                .build());
            }
        }
        return response;
    }

    // etat de stock
    public void registerEtat(Magasin magasin,Timestamp date){
        List<Article_magasin> allArticleInStockByMagasin = new Vector<Article_magasin>();
        allArticleInStockByMagasin = article_magasinRepository.getArticle_in_stocksByIdMagasin(magasin.getId());
            // System.out.println();
            if(allArticleInStockByMagasin.size() > 0){
                 
                for (int i = 0; i < allArticleInStockByMagasin.size(); i++) {
                    List<Article_in_stock> articleInStock = article_in_stockRepository.getStateArticle(allArticleInStockByMagasin.get(i).getArticle().getId(), magasin.getId(), date);
                    double quantite = 0;
                    double prix = 0;
                    double moyenne = 0;
                    for(Article_in_stock artInStock : articleInStock){
                        quantite += artInStock.getQuantity();
                        prix += artInStock.getPrice() * artInStock.getQuantity();
                    }
                    if (prix > 0) {
                        moyenne = prix / quantite;
                        // System.out.println("prix : "+ prix);
                        // System.out.println("quantite :"+ quantite);
                        // System.out.println("moyenne : "+ moyenne);
                        saveEtatStock(allArticleInStockByMagasin.get(i).getArticle(),magasin,quantite,moyenne,date);
                       
                    }

                }
                // System.out.println(etatStock);
              
                
            }else{
                throw new IllegalStateException("There is nothing in stock");
            }
    }

    public List<Mouvement> getAllDetailsMouvement(EtatStock etat_stock_debut,EtatStock etat_stock_fin){
        List<Mouvement> mouve = new Vector<Mouvement>();
        List<Validation> allValidation = validationRepository.geValidation(etat_stock_debut.getArticle().getId(),etat_stock_debut.getMagasin().getId());
        for(Validation validation : allValidation){
            if(validation.getDate_validation().compareTo(etat_stock_debut.getDate()) >= 0
            && validation.getDate_validation().compareTo(etat_stock_fin.getDate()) <= 0){
                mouve.add(validation.getMouvementValider());
            }
        }

        return mouve;
    }

    public void saveEtatStock(Article article,Magasin magasin,double quantite,double moyenne,Timestamp date){
         EtatStock etatStock = EtatStock.builder()
                            .article(article)
                            .quantity(quantite)
                            .date(date)
                            .price(moyenne)
                            .build();
        addNewEtatStock(etatStock);
    }

}
