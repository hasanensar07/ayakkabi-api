package com.bitirmeprojesi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AyakkabiRequestDTO {//post yani put için
    // ID hariç, dışarıdan gelen veriler
    private String urunIsmi;
    private String urunModel;
    private int urunNumara;
    private double satisFiyati;
    private int guncelStok;
    private String ureticiUlke; 
}