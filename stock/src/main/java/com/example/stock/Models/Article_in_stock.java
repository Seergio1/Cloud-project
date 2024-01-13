package com.example.stock.Models;

import java.sql.Timestamp;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "article_in_stock")
@Table(name = "article_in_stock")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article_in_stock {

    @jakarta.persistence.Id
    @SequenceGenerator(name = "article_in_stock_sequence", sequenceName = "article_in_stock_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_in_stock_sequence")
    @Column(name = "id", updatable = false)
    Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_article", unique = false)
    Article article;

    double quantity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_magasin", unique = false)
    Magasin magasin;

    Timestamp date;

    double price;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_mouvement", unique = false)
    Mouvement mouvement;
}
