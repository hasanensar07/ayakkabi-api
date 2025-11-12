package com.bitirmeprojesi.services;

import com.bitirmeprojesi.dto.*;
import java.util.List;

public interface IAyakkabiService {
    AyakkabiResponseDTO save(AyakkabiRequestDTO ayakkabiRequestDTO);
    List<AyakkabiResponseDTO> findAll();
    AyakkabiResponseDTO findById(Long id);
    void deleteById(Long id);
    AyakkabiResponseDTO update(Long urunId, AyakkabiRequestDTO ayakkabiRequestDTO);
    List<AyakkabiResponseDTO> findByUreticiUlke(String ureticiUlke);
}
