package ru.job4j.dish.service;


import ru.job4j.domain.Dish;

import java.util.List;

public interface DishService {

    void addDish(Dish dish);

    Dish findByName(String name);

    Dish findById(int id);

    List<Dish> findAll();
    boolean deleteDish(Dish dish);
}

