package com.bitirmeprojesi.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AyakkabiRequestDTO {

    @NotBlank(message = "Ürün ismi boş bırakılamaz.")
    private String urunIsmi;

    @NotBlank(message = "Ürün modeli boş bırakılamaz.")
    private String urunModel;

    @Min(value = 30, message = "Numara en az 30 olmalıdır.")
    @Max(value = 50, message = "Numara en fazla 50 olabilir.")
    private int urunNumara;

    @Positive(message = "Fiyat 0'dan büyük olmalıdır.")
    private double satisFiyati;

    @Min(value = 0, message = "Stok negatif olamaz.")
    private int guncelStok;

    @NotBlank(message = "Üretici ülke boş bırakılamaz.")
    private String ureticiUlke;
    
}
