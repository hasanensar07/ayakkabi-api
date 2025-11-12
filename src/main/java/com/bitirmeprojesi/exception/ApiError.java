package com.bitirmeprojesi.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.Map;
import java.util.List;
import java.util.Date; // Date yerine LocalDateTime veya Instant kullanılması önerilir

// @Data, @AllArgsConstructor, @NoArgsConstructor anotasyonları sınıfın üstünde olmalıdır.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    
    // Hatanın benzersiz ID'si
    private String id; 
    
    // Hatanın oluştuğu tarih
    private Date dateTime; 
    
    // Hata mesajlarını tutan Map (Alan Adı -> Hata Mesajları Listesi)
    private Map<String, List<String>> errors; 
}