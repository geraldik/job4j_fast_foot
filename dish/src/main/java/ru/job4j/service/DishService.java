package ru.job4j.service;


import ru.job4j.Dish;

import java.util.List;

public interface DishService {

    void addDish(Dish dish);

    Dish findByName(String name);

    Dish findById(int id);

    List<Dish> findAll();

    boolean deleteDish(Dish dish);
}

