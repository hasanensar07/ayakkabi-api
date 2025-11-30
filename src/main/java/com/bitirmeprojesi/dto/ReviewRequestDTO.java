package com.bitirmeprojesi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDTO {
    private int rating;
    private String comment;
    // Ayakkabi ID'sini URL'den alacağız, buraya koymuyoruz.
}