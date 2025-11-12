package com.bitirmeprojesi.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bitirmeprojesi.dto.AyakkabiRequestDTO;
import com.bitirmeprojesi.dto.AyakkabiResponseDTO;
import com.bitirmeprojesi.services.IAyakkabiService;
import com.bitirmeprojesi.controller.IAyakkabiController;

@RestController
@RequestMapping(path = "/api/ayakkabilar")
public class AyakkabiController implements IAyakkabiController {

    @Autowired
    private IAyakkabiService ayakkabiService;

    // GET ALL - Tümünü Listele
    @Override
    @GetMapping(path = "/listele")
    public List<AyakkabiResponseDTO> findAll() {
        return ayakkabiService.findAll();
    }

    // GET BY ID - Tekil Bul
    @Override
    @GetMapping(path = "/listele/{id}")
    public AyakkabiResponseDTO findById(@PathVariable Long id) {
        return ayakkabiService.findById(id);
    }

    // GET FILTER - Filtrele
    @Override
    @GetMapping(path = "/filtrele")
    public List<AyakkabiResponseDTO> ureticiyeGoreGetir(@RequestParam String uretici) {
        return ayakkabiService.findByUreticiUlke(uretici);
    }

    // POST (CREATE) - Yeni Ekle
    @Override
    @PostMapping
    public AyakkabiResponseDTO ayakkabiEkle(@RequestBody AyakkabiRequestDTO yeniAyakkabi) {
        return ayakkabiService.save(yeniAyakkabi);
    }

    // PUT (UPDATE) - Güncelleme
    @Override
    @PutMapping(path = "/listele/{id}")
    public AyakkabiResponseDTO ayakkabiyiGuncelle(@PathVariable Long id,
                                                  @RequestBody AyakkabiRequestDTO guncelAyakkabi) {
        return ayakkabiService.update(id, guncelAyakkabi);
    }

    // DELETE - Sil
    @Override
    @DeleteMapping(path = "/listele/{id}")
    public boolean deleteAyakkabi(@PathVariable Long id) {
        ayakkabiService.deleteById(id);
        return true;
    }
}
