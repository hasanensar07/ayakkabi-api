package com.bitirmeprojesi.controller;

import com.bitirmeprojesi.dto.AyakkabiRequestDTO;
import com.bitirmeprojesi.dto.AyakkabiResponseDTO;
import java.util.List;

public interface IAyakkabiController {

    // GET ALL
    List<AyakkabiResponseDTO> findAll();

    // GET BY ID
    AyakkabiResponseDTO findById(Long id);

    // GET FILTER
    List<AyakkabiResponseDTO> ureticiyeGoreGetir(String uretici);

    // POST (CREATE)
    AyakkabiResponseDTO ayakkabiEkle(AyakkabiRequestDTO yeniAyakkabi);

    // PUT (UPDATE)
    AyakkabiResponseDTO ayakkabiyiGuncelle(Long id, AyakkabiRequestDTO guncelAyakkabi);

    // DELETE
    boolean deleteAyakkabi(Long id);
}
