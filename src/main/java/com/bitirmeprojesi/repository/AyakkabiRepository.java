package com.bitirmeprojesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bitirmeprojesi.model.Ayakkabi;
import java.util.List;

public interface AyakkabiRepository extends JpaRepository<Ayakkabi, Long> {
    List<Ayakkabi> findByUreticiUlke(String ureticiUlke);
}
