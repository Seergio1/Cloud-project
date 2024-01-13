package com.example.stock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Models.Magasin;
import com.example.stock.Service.MagasinService;

@RestController
@RequestMapping(path = "magasin")
public class MagasinController {
    @Autowired
    MagasinService magasinService;

    @GetMapping(path = "/listeMagasin")
    public List<Magasin> getAllMagasin(){
        return magasinService.getAllMagasin();
    }
}
