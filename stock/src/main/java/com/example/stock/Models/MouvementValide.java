package com.example.stock.Models;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MouvementValide {

    Mouvement mouvement_a_valider;

    Timestamp date_validation;
    
}
