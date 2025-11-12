package com.bitirmeprojesi.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.bitirmeprojesi") // tüm katmanları tara
@EntityScan(basePackages = "com.bitirmeprojesi.model") // Entity'leri (Ayakkabi) tara
@EnableJpaRepositories(basePackages = "com.bitirmeprojesi.repository") // JPA repo'ları tara

public class AyakkabiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyakkabiApiApplication.class, args);
    }
}
