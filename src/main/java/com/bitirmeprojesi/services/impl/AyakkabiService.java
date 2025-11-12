package com.bitirmeprojesi.services.impl;

import com.bitirmeprojesi.dto.AyakkabiRequestDTO;
import com.bitirmeprojesi.dto.AyakkabiResponseDTO;
import com.bitirmeprojesi.model.Ayakkabi;
import com.bitirmeprojesi.repository.AyakkabiRepository;
import com.bitirmeprojesi.services.IAyakkabiService;
import org.springframework.beans.BeanUtils; // 👈 DTO dönüşümü için import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors; // 👈 Liste dönüşümü için import

@Service
public class AyakkabiService implements IAyakkabiService {

    @Autowired
    private AyakkabiRepository ayakkabiRepository;

    // --- ÖZEL MAPLEME METOTLARI (Yeniden Kullanım İçin) ---
    // Entity -> Response DTO dönüşümü
    private AyakkabiResponseDTO convertEntityToResponse(Ayakkabi entity) {
        AyakkabiResponseDTO dto = new AyakkabiResponseDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    // --- IMPLEMENT EDİLEN SERVİS METOTLARI ---

    @Override
    public AyakkabiResponseDTO save(AyakkabiRequestDTO requestDTO) {
        // 1. DTO'yu Entity'ye Çevir
        Ayakkabi ayakkabi = new Ayakkabi();
        BeanUtils.copyProperties(requestDTO, ayakkabi);

        // 2. Repository'ye Kaydet (DB ID atar)
        Ayakkabi savedEntity = ayakkabiRepository.save(ayakkabi);

        // 3. Kaydedilmiş Entity'yi Response DTO'ya Çevir ve Döndür
        return convertEntityToResponse(savedEntity);
    }

    @Override
    public List<AyakkabiResponseDTO> findAll() {
        // 1. Tüm Entity'leri al
        List<Ayakkabi> entities = ayakkabiRepository.findAll();

        // 2. Stream ile List<Entity> -> List<Response DTO> yap
        return entities.stream()
                .map(this::convertEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AyakkabiResponseDTO findById(Long id) {
        Optional<Ayakkabi> ayakkabiOptional = ayakkabiRepository.findById(id);

        if (ayakkabiOptional.isPresent()) {
            // Bulunduysa Response DTO'ya çevir
            return convertEntityToResponse(ayakkabiOptional.get());
        } else {
            return null; // Bulunamazsa null döndür
        }
    }

    @Override
    public AyakkabiResponseDTO update(Long urunId, AyakkabiRequestDTO requestDTO) {
        // 1. DTO'yu Entity'ye çevir ve Path'ten gelen ID'yi ata
        Ayakkabi ayakkabi = new Ayakkabi();
        BeanUtils.copyProperties(requestDTO, ayakkabi);
        ayakkabi.setUrunId(urunId); // Güncelleme için ID'yi set et

        // 2. Repository'ye kaydet (ID olduğu için güncelleme yapar)
        Ayakkabi updatedEntity = ayakkabiRepository.save(ayakkabi);

        // 3. Response DTO olarak döndür
        return convertEntityToResponse(updatedEntity);
    }

    @Override
    public void deleteById(Long id) {
        ayakkabiRepository.deleteById(id);
    }

    @Override
    public List<AyakkabiResponseDTO> findByUreticiUlke(String ureticiUlke) {
        // 1. Repository'deki custom metot ile Entity listesini al
        List<Ayakkabi> entities = ayakkabiRepository.findByUreticiUlke(ureticiUlke);

        // 2. Entity listesini Response DTO listesine çevir
        return entities.stream()
                .map(this::convertEntityToResponse)
                .collect(Collectors.toList());
    }
}