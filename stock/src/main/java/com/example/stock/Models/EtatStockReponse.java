package com.example.stock.Models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtatStockReponse {
    EtatStock etat_debut;
    EtatStock etat_fin;
    List<Mouvement> listeMouvement;
}