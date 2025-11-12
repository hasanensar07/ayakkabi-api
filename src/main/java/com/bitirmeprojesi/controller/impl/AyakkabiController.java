package com.bitirmeprojesi.controller.impl;

import com.bitirmeprojesi.dto.*;
import com.bitirmeprojesi.services.IAyakkabiService;
import com.bitirmeprojesi.controller.IAyakkabiController;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ayakkabilar")
public class AyakkabiController implements IAyakkabiController {

    @Autowired
    private IAyakkabiService ayakkabiService;

    @GetMapping("/listele")
    public List<AyakkabiResponseDTO> findAll() {
        return ayakkabiService.findAll();
    }

    @GetMapping("/listele/{id}")
    public AyakkabiResponseDTO findById(@PathVariable Long id) {
        return ayakkabiService.findById(id);
    }

    @GetMapping("/filtrele")
    public List<AyakkabiResponseDTO> ureticiyeGoreGetir(@RequestParam String uretici) {
        return ayakkabiService.findByUreticiUlke(uretici);
    }

    @PostMapping
    public AyakkabiResponseDTO ayakkabiEkle(@Valid @RequestBody AyakkabiRequestDTO yeniAyakkabi) {
        return ayakkabiService.save(yeniAyakkabi);
    }

    @PutMapping("/listele/{id}")
    public AyakkabiResponseDTO ayakkabiyiGuncelle(@PathVariable Long id, @Valid @RequestBody AyakkabiRequestDTO guncelAyakkabi) {
        return ayakkabiService.update(id, guncelAyakkabi);
    }

    @DeleteMapping("/listele/{id}")
    public boolean deleteAyakkabi(@PathVariable Long id) {
        ayakkabiService.deleteById(id);
        return true;
    }
}
