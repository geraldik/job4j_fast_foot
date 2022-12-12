package ru.job4j.order;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"ru.job4j.domain", "ru.job4j.order"})
@EntityScan(basePackages = "ru.job4j.domain")
@EnableJpaRepositories
public class OrderApplication {

    @Bean
    public ModelMapper getModelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return  modelMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}