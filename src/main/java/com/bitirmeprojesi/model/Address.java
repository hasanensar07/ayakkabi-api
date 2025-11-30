package com.bitirmeprojesi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode; 
import lombok.ToString;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    // İLİŞKİ TANIMI: Customer Entity'sine geri bakar.
    // mappedBy="customer" - Customer sınıfındaki değişkenin adıdır.
    @OneToOne(mappedBy = "address") 
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;
}