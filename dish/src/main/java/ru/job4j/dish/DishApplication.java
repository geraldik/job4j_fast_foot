package ru.job4j.dish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"ru.job4j.domain", "ru.job4j.dish"})
@EntityScan(basePackages = "ru.job4j.domain")
public class DishApplication {

    public static void main(String[] args) {
        SpringApplication.run(DishApplication.class, args);
    }
}