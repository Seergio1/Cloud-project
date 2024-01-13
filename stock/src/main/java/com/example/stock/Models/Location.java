package com.example.stock.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "location")
@Table(name = "location")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @jakarta.persistence.Id
    @SequenceGenerator(
        name = "location_sequence",
        sequenceName = "location_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "location_sequence"
    )
    @Column(name = "id", updatable = false)
    Long id;

    @Column(name = "name" ,nullable = false)
    String name;
}
