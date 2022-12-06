package ru.job4j.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.dish.service.DishService;
import ru.job4j.domain.Category;
import ru.job4j.domain.Dish;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DishAPIService implements DishService {

    @Value("${api-url}")
    private String url;

    private final RestTemplate client;

    @Override
    public List<Dish> findAll() {
        List<Dish> body = client.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }

    @Override
    public boolean deleteById(int id) {
        return client.exchange(
                String.format("%s?id=%s", url, id),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    @Override
    public Dish findById(int id) {
        return client.getForEntity(
                String.format("%s/%s", url, id),
                Dish.class
        ).getBody();
    }

    @Override
    public Dish addDish(Dish dish) {
        System.out.println(url);
        return client.postForEntity(
                url, dish, Dish.class
        ).getBody();
    }

    public boolean update(Dish dish) {
        return client.exchange(
                String.format("%s/%s", url, dish.getId()),
                HttpMethod.PUT,
                new HttpEntity<>(dish),
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    @Override
    public Dish findByName(String name) {
        return client.getForEntity(
                String.format("%s/name/%s", url, name),
                Dish.class
        ).getBody();
    }

    public List<Category> findAllCategories() {
        List<Category> body = client.exchange(
                String.format("%s/category", url),
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Category>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }
}
