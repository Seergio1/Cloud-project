package com.example.stock.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleStockQuantity {

    Article_in_stock article_in_stock;
    
    double quantity;

}
