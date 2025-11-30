package com.bitirmeprojesi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // İLİŞKİ TANIMI: Owning Side (Sahip Taraf)
    // Cascade sayesinde Customer kaydedildiğinde Address de kaydedilir.
    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "address_id", referencedColumnName = "id") // Foreign Key kolonu budur.
    private Address address;
}