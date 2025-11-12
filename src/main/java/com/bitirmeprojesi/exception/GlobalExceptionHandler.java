package com.bitirmeprojesi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError; 
import org.springframework.validation.ObjectError; 

import java.util.*; 

@ControllerAdvice // Tüm Controller'lardaki hataları merkezi yakalar
public class GlobalExceptionHandler {

    // Yardımcı metot: Hata listesine yeni değer ekler
    private List<String> addMapValue(List<String> list, String newValue) {
        list.add(newValue);
        return list;
    }

    // Validation hatalarını (MethodArgumentNotValidException) yakalar
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, List<String>> errorsMap = new HashMap<>();

        // Hata alan her bir alanı ve mesajını al
        for (ObjectError objError : ex.getBindingResult().getAllErrors()) {
            
            // FieldError'a dönüştürerek alan adını (urunIsmi, urunNumara) al
            String fieldName = ((FieldError) objError).getField();
            String defaultMessage = objError.getDefaultMessage();

            // Eğer bu alan zaten Map'te varsa, listeye yeni mesajı ekle
            if (errorsMap.containsKey(fieldName)) {
                errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), defaultMessage));
            } 
            // Yoksa yeni bir liste oluşturup mesajı ekle
            else {
                errorsMap.put(fieldName, addMapValue(new ArrayList<>(), defaultMessage));
            }
        }
        
        // 1. ApiError nesnesini oluştur ve hataları ekle
        ApiError apiError = createApiError(errorsMap);

        // 2. HTTP 400 Bad Request ve ApiError nesnesini döndür
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
    
    // Yardımcı Metot: ApiError nesnesini oluşturur (ID ve zaman damgası ekler)
    private ApiError createApiError(Map<String, List<String>> errors) {
        ApiError apiError = new ApiError();
        apiError.setId(UUID.randomUUID().toString()); 
        apiError.setDateTime(new Date());
        apiError.setErrors(errors);
        
        return apiError;
    }
}