package ru.job4j.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.dish.repository.CategoryRepository;
import ru.job4j.domain.Category;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SimpleCategoryService implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public List<Category> findAllCategories() {
       return repository.findAll();
    }

    @Override
    public Category findById(int id) {
        var optionalCategory = repository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new NoSuchElementException("There is no such category by this id");
        }
        return optionalCategory.get();
    }
}
