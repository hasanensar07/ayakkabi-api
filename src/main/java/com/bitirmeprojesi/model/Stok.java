package com.bitirmeprojesi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode; 
import lombok.ToString;

@Entity
@Table(name = "stok")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "beden_numarasi")
    private int bedenNumarasi;

    @Column(name = "adet")
    private int adet;

    // İLİŞKİ TANIMI (Inverse Side - Takipçi Taraf)
    // Hocanın Address sınıfında yaptığı gibi:
    @OneToOne(mappedBy = "stok") 
    @EqualsAndHashCode.Exclude 
    @ToString.Exclude
    private Ayakkabi ayakkabi; // Değişken adı 'ayakkabi'
}