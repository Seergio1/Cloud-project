package com.example.stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.stock.Models.Mouvement;
import com.example.stock.Service.MouvementService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "mouvement")
public class MouvementController {
    @Autowired
    MouvementService mouvementService;

    @PostMapping(path = "/addMouvement")
    public void saveMouvement(@RequestBody Mouvement mouvement) {
        
        mouvementService.addNewMouvement(mouvement);
    }

    @PutMapping(path = "/updateMouvInvalidate")
    public void updateMouvementInvalidate(@RequestBody Mouvement mouvement){
           mouvementService.updateMouvementInvalidate(mouvement);
    }
    
    
}
