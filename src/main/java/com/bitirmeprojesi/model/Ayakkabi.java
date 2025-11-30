package com.bitirmeprojesi.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.CascadeType;

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
    
 

    

    // İLİŞKİ TANIMI (Owning Side - Sahip Taraf)
    // Hocanın Customer sınıfında yaptığı gibi:
    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "stok_id", referencedColumnName = "id") 
    private Stok stok; // Değişken adı 'stok' (mappedBy buna bakıyor)
}
