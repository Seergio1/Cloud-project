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

@Entity(name = "out_method")
@Table(name = "out_method")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Out_method {
    @jakarta.persistence.Id
    @SequenceGenerator(
        name = "out_method_sequence",
        sequenceName = "out_method_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "out_method_sequence"
    )
    @Column(name = "id", updatable = false)
    Long id;

    @Column(name = "name" ,nullable = false)
    String name;
}
