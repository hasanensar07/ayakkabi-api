package com.bitirmeprojesi.services.impl;

import com.bitirmeprojesi.dto.*;
import com.bitirmeprojesi.model.Ayakkabi;
import com.bitirmeprojesi.repository.AyakkabiRepository;
import com.bitirmeprojesi.services.IAyakkabiService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AyakkabiService implements IAyakkabiService {

    @Autowired
    private AyakkabiRepository ayakkabiRepository;

    private AyakkabiResponseDTO convertEntityToResponse(Ayakkabi entity) {
        AyakkabiResponseDTO dto = new AyakkabiResponseDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public AyakkabiResponseDTO save(AyakkabiRequestDTO requestDTO) {
        Ayakkabi ayakkabi = new Ayakkabi();
        BeanUtils.copyProperties(requestDTO, ayakkabi);
        Ayakkabi saved = ayakkabiRepository.save(ayakkabi);
        return convertEntityToResponse(saved);
    }

    @Override
    public List<AyakkabiResponseDTO> findAll() {
        return ayakkabiRepository.findAll()
                .stream()
                .map(this::convertEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AyakkabiResponseDTO findById(Long id) {
        return ayakkabiRepository.findById(id)
                .map(this::convertEntityToResponse)
                .orElse(null);
    }

    @Override
    public AyakkabiResponseDTO update(Long urunId, AyakkabiRequestDTO requestDTO) {
        Ayakkabi ayakkabi = new Ayakkabi();
        BeanUtils.copyProperties(requestDTO, ayakkabi);
        ayakkabi.setUrunId(urunId);
        Ayakkabi updated = ayakkabiRepository.save(ayakkabi);
        return convertEntityToResponse(updated);
    }

    @Override
    public void deleteById(Long id) {
        ayakkabiRepository.deleteById(id);
    }

    @Override
    public List<AyakkabiResponseDTO> findByUreticiUlke(String ureticiUlke) {
        return ayakkabiRepository.findByUreticiUlke(ureticiUlke)
                .stream()
                .map(this::convertEntityToResponse)
                .collect(Collectors.toList());
    }
}
