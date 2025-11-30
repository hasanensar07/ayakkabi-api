package com.bitirmeprojesi.model;

import java.util.*;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ayakkabi", schema = "ayakkabi")
public class Ayakkabi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "urun_id")
    private Long urunId;

    @Column(name = "urun_ismi", nullable = false)
    private String urunIsmi;

    @Column(name = "urun_model", nullable = false)
    private String urunModel;

    @Column(name = "urun_numara", nullable = false)
    private int urunNumara;

    @Column(name = "urun_fiyat")
    private double satisFiyati;

    @Column(name = "urun_stok")
    private int guncelStok;

    @Column(name = "uretici_ulke")
    private String ureticiUlke;
    
 


 // YENİ İLİŞKİ TANIMI: (@OneToMany Side)
 @OneToMany(mappedBy = "ayakkabi", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Review> reviews; // Bu ayakkabıya ait tüm yorumları tutar.
 

//YENİ İLİŞKİ TANIMI (@ManyToMany Side - Owning Side)
@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
@JoinTable(
  // Ara tablonun adı (Hibernate bunu otomatik oluşturur)
  name = "ayakkabi_etiket", 
  // Bu tabloya Ayakkabi ID'si nasıl bağlanacak?
  joinColumns = @JoinColumn(name = "ayakkabi_id"), 
  // Karşı taraftaki Etiket ID'si nasıl bağlanacak?
  inverseJoinColumns = @JoinColumn(name = "etiket_id") 
)
private List<Etiket> etiketler; // Bu ayakkabıya ait tüm etiketleri tutar.
    
 
 

    

    
}
