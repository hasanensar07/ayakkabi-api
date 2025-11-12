package com.bitirmeprojesi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AyakkabiResponseDTO { //get yani dönüş için
    // ID dahil, veritabanından gelen veriler
    private Long urunId;
    private String urunIsmi;
    private String urunModel;
    private int urunNumara;
    private double satisFiyati;
    private int guncelStok;
    private String ureticiUlke;
}