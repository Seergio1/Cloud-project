package com.example.stock.Models;

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

@Entity(name = "mouvement_out_details")
@Table(name = "mouvement_out_details")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mouvement_out_details {
    @jakarta.persistence.Id
    @SequenceGenerator(
        name = "mouvement_out_details_sequence",
        sequenceName = "mouvement_out_details_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "mouvement_out_details_sequence"
    )
    @Column(name = "id", updatable = false)
    Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_mouvement_out" ,unique = false)
    Mouvement mouvement_out;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_magasin_in" ,unique = false)
    Mouvement mouvement_in;

    double quantity;
}
