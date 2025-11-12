package com.bitirmeprojesi.exception;

import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private String id;
    private LocalDateTime dateTime;
    private Map<String, List<String>> errors;
}
