package com.bitirmeprojesi.services.impl;

import com.bitirmeprojesi.dto.AyakkabiRequestDTO;
import com.bitirmeprojesi.dto.AyakkabiResponseDTO;
import com.bitirmeprojesi.model.Ayakkabi;
import com.bitirmeprojesi.repository.AyakkabiRepository;
import com.bitirmeprojesi.services.IAyakkabiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Transactional importu
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional // Tüm yazma işlemlerini garanti altına alır
public class AyakkabiService implements IAyakkabiService {

    @Autowired
    private AyakkabiRepository ayakkabiRepository;

    // Entity -> Response DTO dönüşümü
    private AyakkabiResponseDTO convertEntityToResponse(Ayakkabi entity) {
        AyakkabiResponseDTO dto = new AyakkabiResponseDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    // --- IMPLEMENT EDİLEN SERVİS METOTLARI ---

    // POST: Kaydetme (Controller'ın çağırdığı metot)
    @Override
    public AyakkabiResponseDTO saveAyakkabi(AyakkabiRequestDTO requestDTO) {
        Ayakkabi ayakkabi = new Ayakkabi();
        BeanUtils.copyProperties(requestDTO, ayakkabi);

        // ✅ KRİTİK DÜZELTME: Stok nesnesi, Ayakkabi'yı geri işaret etmeli.
        if (ayakkabi.getStok() != null) {
            ayakkabi.getStok().setAyakkabi(ayakkabi); 
        }
        
        Ayakkabi savedEntity = ayakkabiRepository.save(ayakkabi);
        return convertEntityToResponse(savedEntity);
    }
    
    // UPDATE: Güncelleme
    @Override
    public AyakkabiResponseDTO update(Long urunId, AyakkabiRequestDTO requestDTO) {
        Ayakkabi ayakkabi = new Ayakkabi();
        BeanUtils.copyProperties(requestDTO, ayakkabi);
        ayakkabi.setUrunId(urunId); 
        
        // KRİTİK DÜZELTME: Güncelleme sırasında da ilişkiyi kur.
        if (ayakkabi.getStok() != null) {
            ayakkabi.getStok().setAyakkabi(ayakkabi);
        }
        
        Ayakkabi updatedEntity = ayakkabiRepository.save(ayakkabi);
        return convertEntityToResponse(updatedEntity);
    }

    // GET ALL
    @Override
    public List<AyakkabiResponseDTO> findAll() {
        return ayakkabiRepository.findAll().stream()
                .map(this::convertEntityToResponse)
                .collect(Collectors.toList());
    }

    // GET BY ID
    @Override
    public AyakkabiResponseDTO findById(Long id) {
        return ayakkabiRepository.findById(id)
                .map(this::convertEntityToResponse)
                .orElse(null);
    }

    // DELETE
    @Override
    public void deleteById(Long id) {
        ayakkabiRepository.deleteById(id);
    }

    // GET FILTER
    @Override
    public List<AyakkabiResponseDTO> findByUreticiUlke(String ureticiUlke) {
        return ayakkabiRepository.findByUreticiUlke(ureticiUlke).stream()
                .map(this::convertEntityToResponse)
                .collect(Collectors.toList());
    }
}