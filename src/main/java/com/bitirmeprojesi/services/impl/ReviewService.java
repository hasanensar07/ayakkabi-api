package com.bitirmeprojesi.services.impl;

import com.bitirmeprojesi.dto.ReviewRequestDTO;
import com.bitirmeprojesi.dto.ReviewResponseDTO;
import com.bitirmeprojesi.model.Ayakkabi;
import com.bitirmeprojesi.model.Review;
import com.bitirmeprojesi.repository.AyakkabiRepository; // 👈 Ayakkabıyı bulmak için
import com.bitirmeprojesi.repository.ReviewRepository;
import com.bitirmeprojesi.services.IReviewService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // İlişkili kaydetmeyi garanti eder
public class ReviewService implements IReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    
    @Autowired
    private AyakkabiRepository ayakkabiRepository; // 👈 Ayakkabıyı çekmek için

    // Yardımcı Dönüşüm Metodu
    private ReviewResponseDTO convertEntityToResponse(Review entity) {
        ReviewResponseDTO dto = new ReviewResponseDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public ReviewResponseDTO saveReview(Long ayakkabiId, ReviewRequestDTO requestDTO) {
        
        // 1. Ayakkabıyı Bul (ManyToOne'ın 'One' tarafı)
        Ayakkabi ayakkabi = ayakkabiRepository.findById(ayakkabiId)
                                                .orElseThrow(() -> new RuntimeException("Ayakkabı bulunamadı. ID: " + ayakkabiId)); // Hata fırlatmak daha iyi bir uygulamadır.

        // 2. DTO'yu Review Entity'ye Çevir
        Review review = new Review();
        BeanUtils.copyProperties(requestDTO, review);

        // 3. İLİŞKİYİ KUR (Ayakkabıyı Review'e ata)
        review.setAyakkabi(ayakkabi); 

        // 4. Review'i kaydet (Foreign Key atanır)
        Review savedReview = reviewRepository.save(review);
        
        // 5. Response DTO'ya çevir ve döndür
        return convertEntityToResponse(savedReview);
    }
}