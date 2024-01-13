package com.example.stock.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Models.EtatStock;
import com.example.stock.Models.EtatStockObject;
import com.example.stock.Models.EtatStockReponse;
import com.example.stock.Service.Etat_stockService;



@RestController
@RequestMapping(path = "etat_stock")
public class EtatStockController {
    @Autowired
    Etat_stockService etat_stockService;

   @PostMapping(path = "/getEtatStockByArticleAndMagasin")
    public List<EtatStockReponse> getEtatStockByArticleAndMagasin(@RequestBody EtatStockObject etatStockObject){
        List<EtatStockReponse> resultatStock = etat_stockService.gEtatStockByArticleAndMagasin(etatStockObject.getId_article(), etatStockObject.getId_magasin(), etatStockObject.getDate_first(), etatStockObject.getDate_second());
        return resultatStock;
    }

    @PostMapping(path = "/getEtatStockByMagasin")
    public List<EtatStockReponse> getEtatStockByMagasin(@RequestBody EtatStockObject etatStockObject){
        List<EtatStockReponse> resultatStock = etat_stockService.getEtatStockByMagasin(etatStockObject.getId_magasin(), etatStockObject.getDate_first(), etatStockObject.getDate_second());
        return resultatStock;
    }
}
