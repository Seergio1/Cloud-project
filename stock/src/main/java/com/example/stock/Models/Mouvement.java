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

@Entity(name = "mouvement")
@Table(name = "mouvement")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mouvement {
    @jakarta.persistence.Id
    @SequenceGenerator(
        name = "mouvement_sequence",
        sequenceName = "mouvement_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "mouvement_sequence"
    )
    @Column(name = "id", updatable = false)
    Long id;

    String status_direction;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_article" ,unique = false)
    Article article;

    double quantity;

    double price_unity;

    Timestamp date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_magasin" ,unique = false)
    Magasin magasin;

    /*
     * 10 validé
            * 11 en attente(fa mbola tsy miasa lony)
     * 20 non validé
     */
    int etat;





}
