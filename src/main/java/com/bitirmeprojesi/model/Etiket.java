package com.bitirmeprojesi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode; 
import lombok.ToString;
import java.util.List; 

@Entity
@Table(name = "etiket")
@Data
@AllArgsConstructor
@NoArgsConstructor
// Lombok döngü hatalarını engellemek için listeyi hariç tutuyoruz
@EqualsAndHashCode(exclude = {"ayakkabilar"}) 
@ToString(exclude = {"ayakkabilar"})          
public class Etiket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isim", nullable = false, unique = true)
    private String isim; // Etiketin adı (Örn: Vegan, Kışlık, Koşu)

    // İLİŞKİ TANIMI (Inverse Side - Takipçi Taraf)
    // 'ayakkabilar' değişkeni Ayakkabi Entity'sinde tanımlı.
    @ManyToMany(mappedBy = "etiketler")
    private List<Ayakkabi> ayakkabilar; 
}