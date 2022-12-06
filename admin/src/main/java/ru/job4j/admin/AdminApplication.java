package ru.job4j.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
public class AdminApplication {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(Duration.ofMillis(30000))
                .setReadTimeout(Duration.ofMillis(30000)).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
        log.info("App started at: " + LocalDateTime.now());
        System.out.println("Go to http://localhost:8080/dish");
    }
}