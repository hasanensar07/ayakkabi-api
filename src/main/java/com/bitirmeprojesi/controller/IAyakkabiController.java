package com.bitirmeprojesi.controller;

import com.bitirmeprojesi.dto.*;
import java.util.List;

public interface IAyakkabiController {
    List<AyakkabiResponseDTO> findAll();
    AyakkabiResponseDTO findById(Long id);
    List<AyakkabiResponseDTO> ureticiyeGoreGetir(String uretici);
    AyakkabiResponseDTO ayakkabiEkle(AyakkabiRequestDTO yeniAyakkabi);
    AyakkabiResponseDTO ayakkabiyiGuncelle(Long id, AyakkabiRequestDTO guncelAyakkabi);
    boolean deleteAyakkabi(Long id);
}
