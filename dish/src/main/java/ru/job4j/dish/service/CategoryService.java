package ru.job4j.dish.service;

import ru.job4j.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();

    Category findById(int id);
}
