package com.bitirmeprojesi.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.bitirmeprojesi")
@EntityScan(basePackages = "com.bitirmeprojesi.model")
@EnableJpaRepositories(basePackages = "com.bitirmeprojesi.repository")
public class AyakkabiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyakkabiApiApplication.class, args);
    }
}
