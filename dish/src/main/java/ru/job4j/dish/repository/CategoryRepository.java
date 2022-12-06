package ru.job4j.dish.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.domain.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

   List<Category> findAll();
}
