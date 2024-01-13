package com.example.stock.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Models.Mouvement;
import com.example.stock.Models.MouvementValide;
import com.example.stock.Repository.MouvementRepository;
import com.example.stock.Service.ValidationService;

@RestController
@RequestMapping(path = "validation")
public class ValidationController {
    @Autowired
    ValidationService validationService;

    @Autowired
    MouvementRepository mouvementRepository;

    @PostMapping(path = "/validate")
    public void validateMouvement(@RequestBody MouvementValide mouvementValide){
        validationService.validateEtatMouvement(mouvementValide.getMouvement_a_valider(), mouvementValide.getDate_validation());
    }

    @GetMapping(path = "/allMouvementInvalidate")
    public List<Mouvement> getAllMouvementInvalidate(){
        return mouvementRepository.getAllMouvInvalidate();
    }

    @GetMapping(path = "/mouvementInvalidateByMouvement/{id}")
    public Mouvement getMouvementValidateByIdMouvement(@PathVariable Long id){
        return mouvementRepository.getMouvementInvalidateByIdMouvement(id);
    }
}
