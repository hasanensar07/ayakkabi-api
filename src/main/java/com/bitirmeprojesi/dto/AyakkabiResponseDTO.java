package com.bitirmeprojesi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AyakkabiResponseDTO {
    private Long urunId;
    private String urunIsmi;
    private String urunModel;
    private int urunNumara;
    private double satisFiyati;
    private int guncelStok;
    private String ureticiUlke;
}
