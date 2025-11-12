package com.bitirmeprojesi.services;

import com.bitirmeprojesi.dto.AyakkabiRequestDTO; // Yeni DTO'ları import et
import com.bitirmeprojesi.dto.AyakkabiResponseDTO; // Yeni DTO'ları import et
import java.util.List;

// BU BİR INTERFACE (ARAYÜZ)
public interface IAyakkabiService {

    // C - Kaydet: Request DTO alır, Response DTO döndürür
    AyakkabiResponseDTO save(AyakkabiRequestDTO ayakkabiRequestDTO); 
    
    // R - Tümünü Listele: Response DTO listesi döndürür
    List<AyakkabiResponseDTO> findAll();
    
    // R - ID ile Bul: Response DTO döndürür
    AyakkabiResponseDTO findById(Long id);
    
    // D - Sil: DTO etkilenmez, void kalır
    void deleteById(Long id);
    
    // U - Güncelle: Request DTO alır (güncel veriler), Response DTO döndürür
    AyakkabiResponseDTO update(Long urunId, AyakkabiRequestDTO ayakkabiRequestDTO); 
    
    // R - Filtrele: Response DTO listesi döndürür
    List<AyakkabiResponseDTO> findByUreticiUlke(String ureticiUlke);
}