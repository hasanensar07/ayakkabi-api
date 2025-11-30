package com.bitirmeprojesi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode; 
import lombok.ToString;

@Entity
@Table(name = "review")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"ayakkabi"}) // İlişki döngüsünü engeller
@ToString(exclude = {"ayakkabi"})          // İlişki döngüsünü engeller
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating")
    private int rating; // 1'den 5'e kadar puan

    @Column(name = "comment")
    private String comment; // Yorum metni

    // İLİŞKİ TANIMI (Many Side - Çoklu Taraf)
    // Bu, Ayakkabi tablosuna bakan dış anahtarı (FK) tutan taraftır.
    @ManyToOne(fetch = FetchType.LAZY) // Yorumu çekerken Ayakkabı'yı hemen çekme (performans)
    @JoinColumn(name = "ayakkabi_id", nullable = false) 
    private Ayakkabi ayakkabi; // Hangi ayakkabıya ait olduğunu gösterir
}