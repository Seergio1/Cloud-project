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

@Entity(name = "magasin")
@Table(name = "magasin")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Magasin {
    @jakarta.persistence.Id
    @SequenceGenerator(
        name = "magasin_sequence",
        sequenceName = "magasin_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "magasin_sequence"
    )
    @Column(name = "id", updatable = false)
    Long id;

    @Column(name = "name" ,nullable = false)
    String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_location" ,unique = false)
    Location location;
}
