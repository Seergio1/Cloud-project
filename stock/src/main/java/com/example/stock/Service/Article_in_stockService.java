package com.example.stock.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Models.Article;
import com.example.stock.Models.ArticleStockQuantity;
import com.example.stock.Models.Article_in_stock;
import com.example.stock.Models.Mouvement;
import com.example.stock.Repository.Article_in_stockRepository;

import jakarta.transaction.Transactional;

@Service
public class Article_in_stockService {
    @Autowired
    Article_in_stockRepository article_in_stockRepository;

    @Autowired
    Out_methodService out_methodService;

    @Autowired
    Mouvement_out_detailsService mouvement_out_detailsService;

    public List<Article_in_stock> getAllArticleInStock(){
		return article_in_stockRepository.findAll();
	}

    public void addArticleInStock(Mouvement mouvement) {
        System.out.println("valeur prix et quantité");
        System.out.println(mouvement.getPrice_unity());
        System.out.println(mouvement.getQuantity());
        System.out.println("");
		List<Article_in_stock> articleInStock = article_in_stockRepository.findByNameArticle_in_stocks(mouvement.getArticle().getName());
        Article_in_stock newArticle = new Article_in_stock();
        Article_in_stock article = Article_in_stock.builder()
                .article(mouvement.getArticle())
                .quantity(mouvement.getQuantity())
                .magasin(mouvement.getMagasin())
                .date(mouvement.getDate())
                .price(mouvement.getPrice_unity())
                .mouvement(mouvement)
                .build();
                
       
        if(mouvement.getStatus_direction().equalsIgnoreCase("in")){
                if(mouvement.getPrice_unity()>0 && mouvement.getQuantity()>0){
                

                 article_in_stockRepository.save(article);
                
                }else{
                    throw new IllegalStateException("Invalid price/quantity value during insert new article in stock");
                }
        }else{
            if(mouvement.getQuantity()>0){
                List<Article_in_stock> allArticleMethod = new Vector<Article_in_stock>();
                // FIFO or LIFO
                if(mouvement.getArticle().getOut_method().getName().equalsIgnoreCase(out_methodService.getOutMethodNameById(Long.parseLong("1")))){
                    allArticleMethod = article_in_stockRepository.findArticleFIFO(mouvement.getArticle().getCode());
                }else{
                    allArticleMethod = article_in_stockRepository.findArticleLIFO(mouvement.getArticle().getCode());
                }
                newArticle = article_in_stockRepository.getLatestArticleInStock();
                updateArticleInStock(allArticleMethod,mouvement);
            }
           
        }
    }

    @Transactional
	public void updateArticleInStock(List<Article_in_stock> allArticleMethod,Mouvement mouvementOut){
       
                double quantityNecessaire = mouvementOut.getQuantity();
                double prix_moyen_out = 0; 
                List<ArticleStockQuantity> mvmDetails = new Vector<ArticleStockQuantity>();

                for (int i = 0; i < allArticleMethod.size(); i++) {
                    double min_value = quantityNecessaire - allArticleMethod.get(i).getQuantity();
                    if (min_value>0) {
                        quantityNecessaire = min_value;
                        prix_moyen_out += allArticleMethod.get(i).getPrice() * allArticleMethod.get(i).getQuantity();
                        
                        allArticleMethod.get(i).setQuantity(0.0);
                        
                        mvmDetails.add(ArticleStockQuantity.builder()
                            .article_in_stock(allArticleMethod.get(i))
                            .quantity(allArticleMethod.get(i).getQuantity())
                            .build());
                    }
                    if(min_value<0){
                        double newQuantity = allArticleMethod.get(i).getQuantity() - quantityNecessaire;
                        prix_moyen_out += allArticleMethod.get(i).getPrice() * quantityNecessaire;
                     
                        allArticleMethod.get(i).setQuantity(newQuantity);
                        quantityNecessaire = 0;
                        mvmDetails.add(ArticleStockQuantity.builder()
                            .article_in_stock(allArticleMethod.get(i))
                            .quantity(newQuantity).build());
                        break;
                    }
                    if(min_value==0){
                        prix_moyen_out += allArticleMethod.get(i).getPrice() * quantityNecessaire;
                        quantityNecessaire = 0;
                     
                        allArticleMethod.get(i).setQuantity(0.0);
                        mvmDetails.add(ArticleStockQuantity.builder()
                            .article_in_stock(allArticleMethod.get(i))
                            .quantity(allArticleMethod.get(i).getQuantity())
                            .build());
                        break;
                    }
                    
                }
                if (quantityNecessaire > 0) {
                    throw new RuntimeException("Article"+ mouvementOut.getArticle().getName()+ "in stock is not enough for this movement");
                }

                mouvementOut.setPrice_unity(prix_moyen_out/mouvementOut.getQuantity());
                mouvement_out_detailsService.addNewMouvementDetails(mvmDetails, mouvementOut);
        }

		
	// }

    




}
