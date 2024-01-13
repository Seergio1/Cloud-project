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
public class EtatStockObject {
    long id_article;
    long id_magasin;
    Timestamp date_first;
    Timestamp date_second;
}
