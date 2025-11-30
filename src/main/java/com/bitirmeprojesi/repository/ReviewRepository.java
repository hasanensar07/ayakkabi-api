package com.bitirmeprojesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bitirmeprojesi.model.Review;

// Review Entity'sini ve Long tipindeki ID'sini yönetir.
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Tüm CRUD işlemleri JPA tarafından sağlanır.
}