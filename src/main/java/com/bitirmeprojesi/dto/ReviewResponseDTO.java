package com.bitirmeprojesi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDTO {
    private Long id;
    private int rating;
    private String comment;
    // Ayakkabi ID'sini Response'a dahil etmiyoruz, sadece yorumu gösteriyoruz.
}