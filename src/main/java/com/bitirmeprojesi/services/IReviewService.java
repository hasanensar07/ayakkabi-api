package com.bitirmeprojesi.services;

import com.bitirmeprojesi.dto.ReviewRequestDTO;
import com.bitirmeprojesi.dto.ReviewResponseDTO;

// BU BİR INTERFACE (ARAYÜZ)
public interface IReviewService {
    
    // Yorumu kaydederken, hangi ayakkabıya ait olduğunu belirtmek için Ayakkabı ID'sini alır.
	ReviewResponseDTO saveReview(Long ayakkabiId, ReviewRequestDTO requestDTO);
}